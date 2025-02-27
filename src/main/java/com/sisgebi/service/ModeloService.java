package com.sisgebi.service;

import com.sisgebi.entity.Marca;
import com.sisgebi.entity.Modelo;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.MarcaRepository;
import com.sisgebi.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private MarcaRepository marcaRepository;  // Inyectar MarcaRepository

    public ModeloService(ModeloRepository modeloRepository, MarcaRepository marcaRepository) {
        this.modeloRepository = modeloRepository;
        this.marcaRepository = marcaRepository;
    }

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

    // Filtrar modelos por estado y/o marca
    public List<Modelo> filter(Status status, Long marcaId) {
        if (status != null && marcaId != null) {
            Optional<Marca> marca = marcaRepository.findById(marcaId);
            return marca.map(value -> modeloRepository.findByStatusAndMarca(status, value))
                    .orElseGet(List::of);
        } else if (status != null) {
            return modeloRepository.findByStatus(status);
        } else if (marcaId != null) {
            Optional<Marca> marca = marcaRepository.findById(marcaId);
            return marca.map(modeloRepository::findByMarca).orElseGet(List::of);
        } else {
            return modeloRepository.findAll();
        }
    }
}
