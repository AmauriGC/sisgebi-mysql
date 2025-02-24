package com.sisgebi.controller;

import com.sisgebi.entity.HistoricoBien;
import com.sisgebi.service.HistoricoBienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historico-bien")
public class HistoricoBienController {

    @Autowired
    private HistoricoBienService historicoBienService;

    // Obtener todos los registros históricos
    @GetMapping
    public List<HistoricoBien> getAll() {
        return historicoBienService.getAll();
    }

    // Obtener registro histórico por ID
    @GetMapping("/{id}")
    public ResponseEntity<HistoricoBien> getById(@PathVariable Long id) {
        Optional<HistoricoBien> historicoBien = historicoBienService.getById(id);
        return historicoBien.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear nuevo registro histórico
    @PostMapping
    public ResponseEntity<HistoricoBien> create(@RequestBody HistoricoBien historicoBien) {
        HistoricoBien createdHistoricoBien = historicoBienService.create(historicoBien);
        return ResponseEntity.ok(createdHistoricoBien);
    }

    // Actualizar registro histórico
    @PutMapping("/{id}")
    public ResponseEntity<HistoricoBien> update(@PathVariable Long id, @RequestBody HistoricoBien historicoBien) {
        HistoricoBien updatedHistoricoBien = historicoBienService.update(id, historicoBien);
        return updatedHistoricoBien != null ? ResponseEntity.ok(updatedHistoricoBien) : ResponseEntity.notFound().build();
    }

    // Eliminar registro histórico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        historicoBienService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Filtro para buscar registros históricos
    @GetMapping("/filter")
    public List<HistoricoBien> filter(
            @RequestParam(required = false) Long bienId,
            @RequestParam(required = false) String tipoMovimiento) {
        return historicoBienService.filter(bienId, tipoMovimiento);
    }
}
