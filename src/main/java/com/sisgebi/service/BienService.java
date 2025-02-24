package com.sisgebi.service;

import com.sisgebi.entity.Bien;
import com.sisgebi.repository.BienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BienService {

    @Autowired
    private BienRepository bienRepository;

    // Obtener todos los bienes
    public List<Bien> getAll() {
        return bienRepository.findAll();
    }

    // Obtener bien por ID
    public Optional<Bien> getById(Long id) {
        return bienRepository.findById(id);
    }

    // Crear un nuevo bien
    public Bien create(Bien bien) {
        return bienRepository.save(bien);
    }

    // Actualizar bien
    public Bien update(Long id, Bien bien) {
        if (bienRepository.existsById(id)) {
            bien.setBienId(id);
            return bienRepository.save(bien);
        }
        return null;
    }

    // Eliminar bien
    public void delete(Long id) {
        bienRepository.deleteById(id);
    }

    // Filtro para buscar bienes por tipo, marca, modelo, etc.
    public List<Bien> filter(Long tipoBienId, Long marcaId, Long modeloId, String numeroSerie, String codigo) {
        if (tipoBienId != null && marcaId != null && modeloId != null && numeroSerie != null && codigo != null) {
            return bienRepository.findByTipoBien_TipoBienIdAndMarca_MarcaIdAndModelo_ModeloIdAndNumeroSerieAndCodigo(
                    tipoBienId, marcaId, modeloId, numeroSerie, codigo);
        } else if (tipoBienId != null && marcaId != null && modeloId != null) {
            return bienRepository.findByTipoBien_TipoBienIdAndMarca_MarcaIdAndModelo_ModeloId(tipoBienId, marcaId, modeloId);
        } else if (numeroSerie != null) {
            return bienRepository.findByNumeroSerie(numeroSerie);
        } else if (codigo != null) {
            return bienRepository.findByCodigo(codigo);
        }
        return bienRepository.findAll();
    }
}
