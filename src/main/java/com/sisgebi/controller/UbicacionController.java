package com.sisgebi.controller;

import com.sisgebi.entity.Ubicacion;
import com.sisgebi.enums.TipoUbicacion;
import com.sisgebi.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Ubicacion> getById(@PathVariable Long id) {
        return ubicacionService.getById(id);
    }

    // Crear o actualizar una ubicación
    @PostMapping
    public Ubicacion save(@RequestBody Ubicacion ubicacion) {
        return ubicacionService.save(ubicacion); // Llamada al método save()
    }

    // Actualizar ubicación
    @PutMapping("/{id}")
    public Ubicacion update(@PathVariable Long id, @RequestBody Ubicacion ubicacion) {
        return ubicacionService.update(id, ubicacion);
    }

    // Eliminar ubicación
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ubicacionService.delete(id);
    }

    // Filtro para buscar ubicaciones
    @GetMapping("/filter")
    public List<Ubicacion> filter(
            @RequestParam(required = false) TipoUbicacion tipoUbicacion,
            @RequestParam(required = false) Long areaId,
            @RequestParam(required = false) Long becarioId,
            @RequestParam(required = false) Boolean status) { // Usamos Boolean para el checkbox (Status)
        return ubicacionService.filter(tipoUbicacion, areaId, becarioId, status);
    }
}
