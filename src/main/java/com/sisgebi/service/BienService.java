//package com.sisgebi.service;
//
//import com.sisgebi.entity.Bien;
//import com.sisgebi.repository.BienRepository;
//import org.springframework.beans.factory.annotation.Autowired;
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
//    // Obtener todos los bienes
//    public List<Bien> getAll() {
//        return bienRepository.findAll();
//    }
//
//    // Obtener bien por ID
//    public Optional<Bien> getById(Long id) {
//        return bienRepository.findById(id);
//    }
//
//    // Crear un nuevo bien
//    public Bien create(Bien bien) {
//        return bienRepository.save(bien);
//    }
//
//    // Actualizar bien
//    public Bien update(Long id, Bien bien) {
//        if (bienRepository.existsById(id)) {
//            bien.setBienId(id);
//            return bienRepository.save(bien);
//        }
//        return null;
//    }
//
//    // Eliminar bien
//    public void delete(Long id) {
//        bienRepository.deleteById(id);
//    }
//
//    // Filtro para buscar bienes por tipo, marca, modelo, etc.
//    public List<Bien> filter(Long tipoBienId, Long idMarca, Long idModelo, String numeroSerie, String codigo) {
//        if (tipoBienId != null && idMarca != null && idModelo != null && numeroSerie != null && codigo != null) {
//            return bienRepository.findByTipoBien_TipoBienIdAndMarca_idMarcaAndModelo_idModeloAndNumeroSerieAndCodigo(
//                    tipoBienId, idMarca, idModelo, numeroSerie, codigo);
//        } else if (tipoBienId != null && idMarca != null && idModelo != null) {
//            return bienRepository.findByTipoBien_TipoBienIdAndMarca_idMarcaAndModelo_idModelo(tipoBienId, idMarca, idModelo);
//        } else if (numeroSerie != null) {
//            return bienRepository.findByNumeroSerie(numeroSerie);
//        } else if (codigo != null) {
//            return bienRepository.findByCodigo(codigo);
//        }
//        return bienRepository.findAll();
//    }
//}
