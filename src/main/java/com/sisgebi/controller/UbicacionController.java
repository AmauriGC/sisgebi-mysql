package com.sisgebi.controller;

import com.sisgebi.entity.Ubicacion;
import com.sisgebi.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    // Obtener todas las ubicaciones
    @GetMapping
    public List<Ubicacion> getAll() {
        return ubicacionService.getAll();
    }

    // Obtener ubicación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ubicacion> getById(@PathVariable Long id) {
        Optional<Ubicacion> ubicacion = ubicacionService.getById(id);
        return ubicacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva ubicación
    @PostMapping
    public ResponseEntity<Ubicacion> create(@RequestBody Ubicacion ubicacion) {
        Ubicacion createdUbicacion = ubicacionService.create(ubicacion);
        return ResponseEntity.ok(createdUbicacion);
    }

    // Actualizar ubicación
    @PutMapping("/{id}")
    public ResponseEntity<Ubicacion> update(@PathVariable Long id, @RequestBody Ubicacion ubicacion) {
        Ubicacion updatedUbicacion = ubicacionService.update(id, ubicacion);
        return updatedUbicacion != null ? ResponseEntity.ok(updatedUbicacion) : ResponseEntity.notFound().build();
    }

    // Eliminar ubicación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ubicacionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Filtro para buscar ubicaciones
    @GetMapping("/filter")
    public List<Ubicacion> filter(
            @RequestParam(required = false) String tipoUbicacion,
            @RequestParam(required = false) Long areaComunId,
            @RequestParam(required = false) Long becarioId) {
        return ubicacionService.filter(tipoUbicacion, areaComunId, becarioId);
    }
}
