//package com.sisgebi.service;
//
//import com.sisgebi.entity.HistoricoBien;
//import com.sisgebi.repository.HistoricoBienRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class HistoricoBienService {
//
//    @Autowired
//    private HistoricoBienRepository historicoBienRepository;
//
//    // Obtener todos los registros históricos
//    public List<HistoricoBien> getAll() {
//        return historicoBienRepository.findAll();
//    }
//
//    // Obtener registro histórico por ID
//    public Optional<HistoricoBien> getById(Long id) {
//        return historicoBienRepository.findById(id);
//    }
//
//    // Crear nuevo registro histórico
//    public HistoricoBien create(HistoricoBien historicoBien) {
//        return historicoBienRepository.save(historicoBien);
//    }
//
//    // Actualizar registro histórico
//    public HistoricoBien update(Long id, HistoricoBien historicoBien) {
//        if (historicoBienRepository.existsById(id)) {
//            historicoBien.setHistoricoId(id);
//            return historicoBienRepository.save(historicoBien);
//        }
//        return null;
//    }
//
//    // Eliminar registro histórico
//    public void delete(Long id) {
//        historicoBienRepository.deleteById(id);
//    }
//
//    // Filtrar registros históricos por bien o tipo de movimiento
//    public List<HistoricoBien> filter(Long bienId, String tipoMovimiento) {
//        if (bienId != null && tipoMovimiento != null) {
//            return historicoBienRepository.findByBien_BienIdAndTipoMovimiento(bienId, tipoMovimiento);
//        } else if (bienId != null) {
//            return historicoBienRepository.findByBien_BienId(bienId);
//        } else if (tipoMovimiento != null) {
//            return historicoBienRepository.findByTipoMovimiento(tipoMovimiento);
//        }
//        return historicoBienRepository.findAll();
//    }
//}
