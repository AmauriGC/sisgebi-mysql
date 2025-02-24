//package com.sisgebi.repository;
//
//import com.sisgebi.entity.Bien;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface BienRepository extends JpaRepository<Bien, Long> {
//
//    // Métodos personalizados para los filtros
//    List<Bien> findByTipoBien_TipoBienIdAndMarca_idMarcaAndModelo_idModeloAndNumeroSerieAndCodigo(
//            Long tipoBienId, Long idMarca, Long idModelo, String numeroSerie, String codigo);
//
//    List<Bien> findByTipoBien_TipoBienIdAndMarca_idMarcaAndModelo_idModelo(Long tipoBienId, Long idMarca, Long idModelo);
//
//    List<Bien> findByNumeroSerie(String numeroSerie);
//
//    List<Bien> findByCodigo(String codigo);
//}
