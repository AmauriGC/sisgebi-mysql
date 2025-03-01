package com.sisgebi.controller;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.enums.Status;
import com.sisgebi.service.AreaComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/areas")
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
    public Optional<AreaComun> getById(@PathVariable Long id) {
        return areaComunService.getById(id);
    }

    // Crear una nueva área
    @PostMapping
    public AreaComun create(@RequestBody AreaComun areaComun) {
        return areaComunService.create(areaComun);
    }

    // Actualizar área
    @PutMapping("/{id}")
    public AreaComun update(@PathVariable Long id, @RequestBody AreaComun areaComun) {
        return areaComunService.update(id, areaComun);
    }

    // Eliminar área
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        areaComunService.delete(id);
    }

    // Filtro para buscar áreas por nombre y estado
    @GetMapping("/filter")
    public List<AreaComun> filter(@RequestParam(required = false) Long areaId,
                                  @RequestParam(required = false) Status status,
                                  @RequestParam(required = false) Long responsableId) {
        return areaComunService.filter(areaId, status, responsableId);
    }
}
