package com.sisgebi.controller;

import com.sisgebi.entity.Bien;
import com.sisgebi.enums.Status;
import com.sisgebi.enums.TipoUbicacion;
import com.sisgebi.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bienes")
public class BienController {

    @Autowired
    private BienService bienService;

    // Obtener todos los bienes
    @GetMapping
    public List<Bien> getAllBienes() {
        return bienService.getAllBienes();
    }

    // Obtener un bien por id
    @GetMapping("/{id}")
    public ResponseEntity<Bien> getBienById(@PathVariable Long id) {
        Optional<Bien> bien = bienService.getBienById(id);
        return bien.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo bien
    @PostMapping
    public ResponseEntity<Bien> createBien(@RequestBody Bien bien) {
        Bien createdBien = bienService.createBien(bien);
        return new ResponseEntity<>(createdBien, HttpStatus.CREATED);
    }

    // Actualizar un bien
    @PutMapping("/{id}")
    public ResponseEntity<Bien> updateBien(@PathVariable Long id, @RequestBody Bien bien) {
        Bien updatedBien = bienService.updateBien(id, bien);
        return updatedBien != null ? ResponseEntity.ok(updatedBien) : ResponseEntity.notFound().build();
    }

    // Eliminar un bien
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBien(@PathVariable Long id) {
        bienService.deleteBien(id);
        return ResponseEntity.noContent().build();
    }

    // Filtrar bienes
    @GetMapping("/filter")
    public List<Bien> filter(@RequestParam(required = false) String codigo,
                             @RequestParam(required = false) String numeroSerie,
                             @RequestParam(required = false) Long tipoBienId,
                             @RequestParam(required = false) Long marcaId,
                             @RequestParam(required = false) Long modeloId,
                             @RequestParam(required = false) TipoUbicacion tipoUbicacion,
                             @RequestParam(required = false) Long areaComunId,
                             @RequestParam(required = false) Long becarioId,
                             @RequestParam(required = false) Long responsableId,
                             @RequestParam(required = false) Status status) {
        return bienService.filter(codigo, numeroSerie, tipoBienId, marcaId, modeloId, tipoUbicacion,
                areaComunId, becarioId, responsableId, status);
    }
}
