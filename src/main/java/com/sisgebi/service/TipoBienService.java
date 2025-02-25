package com.sisgebi.service;

import com.sisgebi.entity.TipoBien;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.TipoBienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoBienService {

    @Autowired
    private TipoBienRepository tipoBienRepository;

    public TipoBienService(TipoBienRepository tipoBienRepository) {
        this.tipoBienRepository = tipoBienRepository;
    }

    // Obtener todos los tipos de bien
    public List<TipoBien> getAll() {
        return tipoBienRepository.findAll();
    }

    // Obtener tipo de bien por ID
    public Optional<TipoBien> getById(Long id) {
        return tipoBienRepository.findById(id);
    }

    // Crear nuevo tipo de bien
    public TipoBien create(TipoBien tipoBien) {
        return tipoBienRepository.save(tipoBien);
    }

    // Actualizar tipo de bien
    public TipoBien update(Long id, TipoBien tipoBien) {
        if (tipoBienRepository.existsById(id)) {
            tipoBien.setTipoBienId(id);
            return tipoBienRepository.save(tipoBien);
        }
        return null;
    }

    // Eliminar tipo de bien
    public void delete(Long id) {
        tipoBienRepository.deleteById(id);
    }

    // Filtro
    public List<TipoBien> filter(Boolean filtrarPorTipoBien, Status status) {
        if (Boolean.TRUE.equals(filtrarPorTipoBien) && status != null) {
            return tipoBienRepository.findByStatus(status); // Filtra solo por estado si se activó "TipoBien"
        } else if (Boolean.TRUE.equals(filtrarPorTipoBien)) {
            return tipoBienRepository.findAll(); // Si solo activó "TipoBien", trae todos
        } else if (status != null) {
            return tipoBienRepository.findByStatus(status); // Si solo hay status, filtra por estado
        } else {
            return tipoBienRepository.findAll(); // Si no hay filtros, devuelve todo
        }
    }
}
