package com.sisgebi.service;

import com.sisgebi.entity.Modelo;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    // Obtener todos los modelos
    public List<Modelo> getAll() {
        return modeloRepository.findAll();
    }

    // Obtener modelo por ID
    public Optional<Modelo> getById(Long id) {
        return modeloRepository.findById(id);
    }

    // Crear un nuevo modelo
    public Modelo create(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    // Actualizar modelo
    public Modelo update(Long id, Modelo modelo) {
        if (modeloRepository.existsById(id)) {
            modelo.setModeloId(id);
            return modeloRepository.save(modelo);
        }
        return null;
    }

    // Eliminar modelo
    public void delete(Long id) {
        modeloRepository.deleteById(id);
    }

    // Filtro para buscar modelos por nombre, estado y marca
    public List<Modelo> filter(String nombreModelo, Status status, Long marcaId) {
        if (nombreModelo != null && status != null && marcaId != null) {
            return modeloRepository.findByNombreModeloAndStatusAndMarcaId(nombreModelo, status, marcaId);
        } else if (nombreModelo != null && status != null) {
            return modeloRepository.findByNombreModeloAndStatus(nombreModelo, status);
        } else if (nombreModelo != null) {
            return modeloRepository.findByNombreModelo(nombreModelo);
        } else if (status != null) {
            return modeloRepository.findByStatus(status);
        } else if (marcaId != null) {
            return modeloRepository.findByMarcaId(marcaId);
        }
        return modeloRepository.findAll();
    }
}
