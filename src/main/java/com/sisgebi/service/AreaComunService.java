package com.sisgebi.service;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.AreaComunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaComunService {

    @Autowired
    private AreaComunRepository areaComunRepository;

    public AreaComunService(AreaComunRepository areaComunRepository) {
        this.areaComunRepository = areaComunRepository;
    }

    // Obtener todas las áreas
    public List<AreaComun> getAll() {
        return areaComunRepository.findAll();
    }

    // Obtener área por ID
    public Optional<AreaComun> getById(Long id) {
        return areaComunRepository.findById(id);
    }

    // Crear una nueva área
    public AreaComun create(AreaComun areaComun) {
        return areaComunRepository.save(areaComun);
    }

    // Actualizar área
    public AreaComun update(Long id, AreaComun areaComun) {
        if (areaComunRepository.existsById(id)) {
            areaComun.setAreaId(id);
            return areaComunRepository.save(areaComun);
        }
        return null;
    }

    // Eliminar área
    public void delete(Long id) {
        areaComunRepository.deleteById(id);
    }

    // Filtrar áreas comunes según ID y/o estado
    public List<AreaComun> filter(Long areaId, Status status) {
        if (areaId != null && status != null) {
            return areaComunRepository.findByareaIdAndStatus(areaId, status); // Filtra por área y estado
        } else if (areaId != null) {
            return areaComunRepository.findById(areaId).map(List::of).orElse(List.of()); // Filtra solo por área
        } else if (status != null) {
            return areaComunRepository.findByStatus(status); // Filtra solo por estado
        } else {
            return areaComunRepository.findAll(); // Si no hay filtros, devuelve todo
        }
    }
}
