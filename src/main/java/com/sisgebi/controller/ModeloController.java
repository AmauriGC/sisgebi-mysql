package com.sisgebi.controller;

import com.sisgebi.entity.Modelo;
import com.sisgebi.enums.Status;
import com.sisgebi.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    // Obtener todos los modelos
    @GetMapping
    public List<Modelo> getAll() {
        return modeloService.getAll();
    }

    // Obtener modelo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Modelo> getById(@PathVariable Long id) {
        Optional<Modelo> modelo = modeloService.getById(id);
        return modelo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo modelo
    @PostMapping
    public ResponseEntity<Modelo> create(@RequestBody Modelo modelo) {
        Modelo createdModelo = modeloService.create(modelo);
        return new ResponseEntity<>(createdModelo, HttpStatus.CREATED);
    }

    // Actualizar modelo
    @PutMapping("/{id}")
    public ResponseEntity<Modelo> update(@PathVariable Long id, @RequestBody Modelo modelo) {
        Modelo updatedModelo = modeloService.update(id, modelo);
        return updatedModelo != null ? ResponseEntity.ok(updatedModelo) : ResponseEntity.notFound().build();
    }

    // Eliminar modelo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        modeloService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Filtro para buscar modelos por nombre, estado y marca
    @GetMapping("/filter")
    public List<Modelo> filter(
            @RequestParam(required = false) Long idMarca, // Recibimos el id de la marca
            @RequestParam(required = false) String nombreModelo,
            @RequestParam(required = false) Status status) {

        return modeloService.filter(idMarca, nombreModelo, status);  // Llamada directa al servicio
    }
}
