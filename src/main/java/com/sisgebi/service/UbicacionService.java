//package com.sisgebi.service;
//
//import com.sisgebi.entity.Ubicacion;
//import com.sisgebi.enums.TipoUbicacion;
//import com.sisgebi.repository.UbicacionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UbicacionService {
//
//    @Autowired
//    private UbicacionRepository ubicacionRepository;
//
//    // Obtener todas las ubicaciones
//    public List<Ubicacion> getAll() {
//        return ubicacionRepository.findAll();
//    }
//
//    // Obtener ubicación por ID
//    public Optional<Ubicacion> getById(Long id) {
//        return ubicacionRepository.findById(id);
//    }
//
//    // Crear una nueva ubicación
//    public Ubicacion create(Ubicacion ubicacion) {
//        return ubicacionRepository.save(ubicacion);
//    }
//
//    // Actualizar ubicación
//    public Ubicacion update(Long id, Ubicacion ubicacion) {
//        if (ubicacionRepository.existsById(id)) {
//            ubicacion.setUbicacionId(id);
//            return ubicacionRepository.save(ubicacion);
//        }
//        return null;
//    }
//
//    // Eliminar ubicación
//    public void delete(Long id) {
//        ubicacionRepository.deleteById(id);
//    }
//
//    // Filtro para buscar ubicaciones por tipo, área y becario
//    public List<Ubicacion> filter(String tipoUbicacionStr, Long areaId, Long becarioId) {
//        TipoUbicacion tipoUbicacion = null;
//        if (tipoUbicacionStr != null) {
//            tipoUbicacion = TipoUbicacion.valueOf(tipoUbicacionStr.toUpperCase()); // Convertir String a Enum
//        }
//
//        if (tipoUbicacion != null && areaId != null && becarioId != null) {
//            return ubicacionRepository.findByTipoUbicacionAndAreaComun_AreaIdAndBecario_Id(tipoUbicacion, areaId, becarioId);
//        } else if (tipoUbicacion != null && areaId != null) {
//            return ubicacionRepository.findByTipoUbicacionAndAreaComun_AreaId(tipoUbicacion, areaId);
//        } else if (tipoUbicacion != null && becarioId != null) {
//            return ubicacionRepository.findByTipoUbicacionAndBecario_Id(tipoUbicacion, becarioId);
//        } else if (areaId != null && becarioId != null) {
//            return ubicacionRepository.findByAreaComun_AreaIdAndBecario_Id(areaId, becarioId);
//        } else if (tipoUbicacion != null) {
//            return ubicacionRepository.findByTipoUbicacion(tipoUbicacion);
//        } else if (areaId != null) {
//            return ubicacionRepository.findByAreaComun_AreaId(areaId);
//        } else if (becarioId != null) {
//            return ubicacionRepository.findByBecario_Id(becarioId);
//        }
//
//        return ubicacionRepository.findAll();
//    }
//
//
//}
