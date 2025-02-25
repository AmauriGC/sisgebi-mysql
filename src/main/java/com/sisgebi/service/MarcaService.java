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
    public Optional<Marca> getById(Long idMarca) {
        return marcaRepository.findById(idMarca);
    }

    // Crear una nueva marca
    public Marca create(Marca marca) {
        return marcaRepository.save(marca);
    }

    // Actualizar una marca existente
    public Marca update(Long idMarca, Marca marca) {
        if (marcaRepository.existsById(idMarca)) {
            marca.setidMarca(idMarca);
            return marcaRepository.save(marca);
        }
        return null; // O lanzar excepción
    }

    // Eliminar una marca por ID
    public boolean delete(Long idMarca) {
        if (marcaRepository.existsById(idMarca)) {
            marcaRepository.deleteById(idMarca);
            return true;
        }
        return false; // O lanzar excepción
    }

    // Filtrar marcas según ID y/o estado
    public List<Marca> filter(Long idMarca, Status status) {
        if (idMarca != null && status != null) {
            return marcaRepository.findByIdMarcaAndStatus(idMarca, status); // Filtra por marca y estado
        } else if (idMarca != null) {
            return marcaRepository.findById(idMarca).map(List::of).orElse(List.of()); // Filtra solo por marca
        } else if (status != null) {
            return marcaRepository.findByStatus(status); // Filtra solo por estado
        } else {
            return marcaRepository.findAll(); // Si no hay filtros, devuelve todo
        }
    }
}