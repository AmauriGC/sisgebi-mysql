package com.sisgebi.service;

import com.sisgebi.entity.Marca;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    // Obtener todas las marcas
    public List<Marca> getAll() {
        return marcaRepository.findAll();
    }

    // Obtener una marca por ID
    public Optional<Marca> getById(Long marcaId) {
        return marcaRepository.findById(marcaId);
    }

    // Crear una nueva marca
    public Marca create(Marca marca) {
        return marcaRepository.save(marca);
    }

    // Actualizar una marca existente
    public Marca update(Long marcaId, Marca marca) {
        if (marcaRepository.existsById(marcaId)) {
            marca.setMarcaId(marcaId);
            return marcaRepository.save(marca);
        }
        return null; // O lanzar excepción
    }

    // Eliminar una marca por ID
    public boolean delete(Long marcaId) {
        if (marcaRepository.existsById(marcaId)) {
            marcaRepository.deleteById(marcaId);
            return true;
        }
        return false; // O lanzar excepción
    }

    // Filtro para marcas
    public List<Marca> filter(String nombreMarca, Status status) {
        return marcaRepository.findByNombreMarcaContainingIgnoreCaseAndStatus(nombreMarca, status);
    }
}
