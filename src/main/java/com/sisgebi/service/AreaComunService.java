//package com.sisgebi.service;
//
//import com.sisgebi.entity.AreaComun;
//import com.sisgebi.enums.Status;
//import com.sisgebi.repository.AreaComunRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AreaComunService {
//
//    @Autowired
//    private AreaComunRepository areaComunRepository;
//
//    // Obtener todas las áreas
//    public List<AreaComun> getAll() {
//        return areaComunRepository.findAll();
//    }
//
//    // Obtener área por ID
//    public Optional<AreaComun> getById(Long id) {
//        return areaComunRepository.findById(id);
//    }
//
//    // Crear una nueva área
//    public AreaComun create(AreaComun areaComun) {
//        return areaComunRepository.save(areaComun);
//    }
//
//    // Actualizar área
//    public AreaComun update(Long id, AreaComun areaComun) {
//        if (areaComunRepository.existsById(id)) {
//            areaComun.setAreaId(id);
//            return areaComunRepository.save(areaComun);
//        }
//        return null;
//    }
//
//    // Eliminar área
//    public void delete(Long id) {
//        areaComunRepository.deleteById(id);
//    }
//
//    // Filtro para buscar áreas por nombre y estado
//    public List<AreaComun> filter(String nombreArea, Status status) {
//        if (nombreArea != null && status != null) {
//            return areaComunRepository.findByNombreAreaAndStatus(nombreArea, status);
//        } else if (nombreArea != null) {
//            return areaComunRepository.findByNombreArea(nombreArea);
//        } else if (status != null) {
//            return areaComunRepository.findByStatus(status);
//        }
//        return areaComunRepository.findAll();
//    }
//}
