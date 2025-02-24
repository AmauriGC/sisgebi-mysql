//package com.sisgebi.service;
//
//import com.sisgebi.entity.Ubicacion;
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
//    public List<Ubicacion> filter(String tipoUbicacion, Long areaComunId, Long becarioId) {
//        if (tipoUbicacion != null && areaComunId != null && becarioId != null) {
//            return ubicacionRepository.findByTipoUbicacionAndAreaComun_AreaIdAndBecario_UsuarioId(tipoUbicacion, areaComunId, becarioId);
//        } else if (tipoUbicacion != null && areaComunId != null) {
//            return ubicacionRepository.findByTipoUbicacionAndAreaComun_AreaId(tipoUbicacion, areaComunId);
//        } else if (tipoUbicacion != null && becarioId != null) {
//            return ubicacionRepository.findByTipoUbicacionAndBecario_UsuarioId(tipoUbicacion, becarioId);
//        } else if (areaComunId != null && becarioId != null) {
//            return ubicacionRepository.findByAreaComun_AreaIdAndBecario_UsuarioId(areaComunId, becarioId);
//        } else if (tipoUbicacion != null) {
//            return ubicacionRepository.findByTipoUbicacion(tipoUbicacion);
//        } else if (areaComunId != null) {
//            return ubicacionRepository.findByAreaComun_AreaId(areaComunId);
//        } else if (becarioId != null) {
//            return ubicacionRepository.findByBecario_UsuarioId(becarioId);
//        }
//        return ubicacionRepository.findAll();
//    }
//}
