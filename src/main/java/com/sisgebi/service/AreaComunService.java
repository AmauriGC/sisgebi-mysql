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

    // Filtro
    public List<AreaComun> filter(Boolean filtrarPorArea, Status status) {
        if (Boolean.TRUE.equals(filtrarPorArea) && status != null) {
            return areaComunRepository.findByStatus(status); // Filtra solo por estado si se activó "Área"
        } else if (Boolean.TRUE.equals(filtrarPorArea)) {
            return areaComunRepository.findAll(); // Si solo activó "Área", trae todas
        } else if (status != null) {
            return areaComunRepository.findByStatus(status); // Si solo hay status, filtra por estado
        } else {
            return areaComunRepository.findAll(); // Si no hay filtros, devuelve todo
        }
    }
}
