//package com.sisgebi.repository;
//
//import com.sisgebi.entity.HistoricoBien;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface HistoricoBienRepository extends JpaRepository<HistoricoBien, Long> {
//
//    // Métodos personalizados para filtrado por bien y tipo de movimiento
//    List<HistoricoBien> findByBien_BienId(Long bienId);
//
//    List<HistoricoBien> findByTipoMovimiento(String tipoMovimiento);
//
//    List<HistoricoBien> findByBien_BienIdAndTipoMovimiento(Long bienId, String tipoMovimiento);
//}
