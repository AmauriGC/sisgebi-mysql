package com.sisgebi.controller;

import com.sisgebi.entity.Marca;
import com.sisgebi.enums.Status;
import com.sisgebi.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    // Obtener todas las marcas
    @GetMapping
    public List<Marca> getAll() {
        return marcaService.getAll();
    }

    // Obtener marca por ID
    @GetMapping("/{id}")
    public Optional<Marca> getById(@PathVariable Long id) {
        return marcaService.getById(id);
    }

    // Crear una nueva marca
    @PostMapping
    public Marca create(@RequestBody Marca marca) {
        return marcaService.create(marca);
    }

    // Actualizar una marca existente
    @PutMapping("/{id}")
    public Marca update(@PathVariable Long id, @RequestBody Marca marca) {
        return marcaService.update(id, marca);
    }

    // Eliminar una marca
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return marcaService.delete(id);
    }

    // Filtrar marcas
    @GetMapping("/filter")
    public List<Marca> filter(@RequestParam(required = false) Long marcaId,
                              @RequestParam(required = false) Status status) {
        return marcaService.filter(marcaId, status);
    }
}
