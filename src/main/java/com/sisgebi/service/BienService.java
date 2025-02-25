//package com.sisgebi.service;
//
//import com.sisgebi.entity.Bien;
//import com.sisgebi.enums.EstadoBien;
//import com.sisgebi.repository.BienRepository;
//import com.sisgebi.specification.BienSpecification;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BienService {
//
//    @Autowired
//    private BienRepository bienRepository;
//
//
//    public BienService(BienRepository bienRepository) {
//        this.bienRepository = bienRepository;
//    }
//
//    // Obtener todos los bienes
//    public List<Bien> getAll() {
//        return bienRepository.findAll();
//    }
//
//    // Obtener un bien por ID
//    public Optional<Bien> getById(Long bienId) {
//        return bienRepository.findById(bienId);
//    }
//
//    // Crear un nuevo bien
//    public Bien create(Bien bien) {
//        return bienRepository.save(bien);
//    }
//
//    // Actualizar un bien existente
//    public Bien update(Long bienId, Bien bien) {
//        if (bienRepository.existsById(bienId)) {
//            bien.setBienId(bienId);
//            return bienRepository.save(bien);
//        }
//        return null; // O lanzar excepción
//    }
//
//    // Eliminar un bien por ID
//    public boolean delete(Long bienId) {
//        if (bienRepository.existsById(bienId)) {
//            bienRepository.deleteById(bienId);
//            return true;
//        }
//        return false; // O lanzar excepción
//    }
//
//    // Filtro combinando checkboxes y React Select
//    public List<Bien> filter(Long tipoBienId, Long marcaId, Long modeloId, EstadoBien estadoBien) {
//        Specification<Bien> spec = Specification.where(null);
//
//        if (tipoBienId != null) {
//            spec = spec.and(BienSpecification.filtroPorTipoBien(tipoBienId));
//        }
//        if (marcaId != null) {
//            spec = spec.and(BienSpecification.filtroPorMarca(marcaId));
//        }
//        if (modeloId != null) {
//            spec = spec.and(BienSpecification.filtroPorModelo(modeloId));
//        }
//        if (estadoBien != null) {
//            spec = spec.and(BienSpecification.filtroPorEstado(estadoBien));
//        }
//
//        return bienRepository.findAll(spec);
//    }
//
//}
