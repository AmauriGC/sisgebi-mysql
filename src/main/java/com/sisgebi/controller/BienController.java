//package com.sisgebi.controller;
//
//import com.sisgebi.entity.Bien;
//import com.sisgebi.enums.EstadoBien;
//import com.sisgebi.service.BienService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/bienes")
//public class BienController {
//
//    @Autowired
//    private BienService bienService;
//
//    // Obtener todos los bienes
//    @GetMapping
//    public List<Bien> getAll() {
//        return bienService.getAll();
//    }
//
//    // Obtener bien por ID
//    @GetMapping("/{id}")
//    public Optional<Bien> getById(@PathVariable Long id) {
//        return bienService.getById(id);
//    }
//
//    // Crear un nuevo bien
//    @PostMapping
//    public Bien create(@RequestBody Bien bien) {
//        return bienService.create(bien);
//    }
//
//    // Actualizar un bien existente
//    @PutMapping("/{id}")
//    public Bien update(@PathVariable Long id, @RequestBody Bien bien) {
//        return bienService.update(id, bien);
//    }
//
//    // Eliminar un bien
//    @DeleteMapping("/{id}")
//    public boolean delete(@PathVariable Long id) {
//        return bienService.delete(id);
//    }
//
//    // Filtro con checkboxes y enums combinados
//    @GetMapping("/filter")
//    public List<Bien> filter(
//            @RequestParam(required = false) Long tipoBienId,
//            @RequestParam(required = false) Long marcaId,
//            @RequestParam(required = false) Long modeloId,
//            @RequestParam(required = false) EstadoBien estadoBien
//    ) {
//        return bienService.filter(tipoBienId, marcaId, modeloId, estadoBien);
//    }
//}
