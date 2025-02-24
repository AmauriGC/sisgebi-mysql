package com.sisgebi.controller;

import com.sisgebi.entity.Bien;
import com.sisgebi.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bien")
public class BienController {

    @Autowired
    private BienService bienService;

    // Obtener todos los bienes
    @GetMapping
    public List<Bien> getAll() {
        return bienService.getAll();
    }

    // Obtener bien por ID
    @GetMapping("/{id}")
    public ResponseEntity<Bien> getById(@PathVariable Long id) {
        Optional<Bien> bien = bienService.getById(id);
        return bien.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo bien
    @PostMapping
    public ResponseEntity<Bien> create(@RequestBody Bien bien) {
        Bien createdBien = bienService.create(bien);
        return ResponseEntity.ok(createdBien);
    }

    // Actualizar bien
    @PutMapping("/{id}")
    public ResponseEntity<Bien> update(@PathVariable Long id, @RequestBody Bien bien) {
        Bien updatedBien = bienService.update(id, bien);
        return updatedBien != null ? ResponseEntity.ok(updatedBien) : ResponseEntity.notFound().build();
    }

    // Eliminar bien
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bienService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Filtro para buscar bienes
    @GetMapping("/filter")
    public List<Bien> filter(
            @RequestParam(required = false) Long tipoBienId,
            @RequestParam(required = false) Long marcaId,
            @RequestParam(required = false) Long modeloId,
            @RequestParam(required = false) String numeroSerie,
            @RequestParam(required = false) String codigo) {
        return bienService.filter(tipoBienId, marcaId, modeloId, numeroSerie, codigo);
    }
}
