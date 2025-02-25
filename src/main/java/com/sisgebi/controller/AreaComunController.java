package com.sisgebi.controller;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.enums.Status;
import com.sisgebi.service.AreaComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/area-comun")
public class AreaComunController {

    @Autowired
    private AreaComunService areaComunService;

    public AreaComunController(AreaComunService areaComunService) {
        this.areaComunService = areaComunService;
    }

    // Obtener todas las áreas
    @GetMapping
    public List<AreaComun> getAll() {
        return areaComunService.getAll();
    }

    // Obtener área por ID
    @GetMapping("/{id}")
    public ResponseEntity<AreaComun> getById(@PathVariable Long id) {
        Optional<AreaComun> areaComun = areaComunService.getById(id);
        return areaComun.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva área
    @PostMapping
    public ResponseEntity<AreaComun> create(@RequestBody AreaComun areaComun) {
        AreaComun createdArea = areaComunService.create(areaComun);
        return new ResponseEntity<>(createdArea, HttpStatus.CREATED);
    }

    // Actualizar área
    @PutMapping("/{id}")
    public ResponseEntity<AreaComun> update(@PathVariable Long id, @RequestBody AreaComun areaComun) {
        AreaComun updatedArea = areaComunService.update(id, areaComun);
        return updatedArea != null ? ResponseEntity.ok(updatedArea) : ResponseEntity.notFound().build();
    }

    // Eliminar área
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        areaComunService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Filtro para buscar áreas por nombre y estado
    @GetMapping("/filter")
    public List<AreaComun> filter(@RequestParam(required = false) Long areaId,
                                  @RequestParam(required = false) Status status) {
        return areaComunService.filter(areaId, status);
    }
}
