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

    // Filtro para buscar tipos de bien por nombre o estado
    public List<TipoBien> filter(String nombreTipoBien, Status status) {
        if (nombreTipoBien != null && status != null) {
            return tipoBienRepository.findByNombreTipoBienAndStatus(nombreTipoBien, status);
        } else if (nombreTipoBien != null) {
            return tipoBienRepository.findByNombreTipoBien(nombreTipoBien);
        } else if (status != null) {
            return tipoBienRepository.findByStatus(status);
        }
        return tipoBienRepository.findAll();
    }
}
