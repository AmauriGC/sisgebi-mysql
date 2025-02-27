package com.sisgebi.controller;

import com.sisgebi.entity.Asignaciones;
import com.sisgebi.enums.Status;
import com.sisgebi.service.AsignacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionesController {

    @Autowired
    private AsignacionesService asignacionesService;

    // Obtener todos las asignaciones
    @GetMapping
    public List<Asignaciones> getAllAsignaciones() {
        return asignacionesService.getAllAsignaciones();
    }

    // Obtener una asignacion por id
    @GetMapping("/{id}")
    public ResponseEntity<Asignaciones> getAsignacionesById(@PathVariable Long id) {
        Optional<Asignaciones> asignacion = asignacionesService.getAsignacionesById(id);
        return asignacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva asignacion
    @PostMapping
    public ResponseEntity<Asignaciones> createAsignaciones(@RequestBody Asignaciones asignacion) {
        Asignaciones createdAsignaciones = asignacionesService.createAsignaciones(asignacion);
        return new ResponseEntity<>(createdAsignaciones, HttpStatus.CREATED);
    }

    // Actualizar una asignacion
    @PutMapping("/{id}")
    public ResponseEntity<Asignaciones> updateAsignaciones(@PathVariable Long id, @RequestBody Asignaciones asignacion) {
        Asignaciones updatedAsignaciones = asignacionesService.updateAsignaciones(id, asignacion);
        return updatedAsignaciones != null ? ResponseEntity.ok(updatedAsignaciones) : ResponseEntity.notFound().build();
    }

    // Eliminar una asignacion
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignaciones(@PathVariable Long id) {
        asignacionesService.deleteAsignaciones(id);
        return ResponseEntity.noContent().build();
    }

    // Filtrar asignaciones
    @GetMapping("/filter")
    public List<Asignaciones> filter(@RequestParam(required = false) Long becarioId,
                                     @RequestParam(required = false) Long responsableId,
                                     @RequestParam(required = false) Status status) {
        return asignacionesService.filter(becarioId, responsableId, status);
    }
}
