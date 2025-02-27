package com.sisgebi.service;

import com.sisgebi.entity.Asignaciones;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.AsignacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignacionesService {

    @Autowired
    private AsignacionesRepository asignacionesRepository;

    public AsignacionesService(AsignacionesRepository asignacionesRepository) {
        this.asignacionesRepository = asignacionesRepository;
    }

    // Obtener todos los Asignacioneses
    public List<Asignaciones> getAllAsignaciones() {
        return asignacionesRepository.findAll();
    }

    // Obtener Asignaciones por id
    public Optional<Asignaciones> getAsignacionesById(Long id) {
        return asignacionesRepository.findById(id);
    }

    // Crear un nuevo Asignaciones
    public Asignaciones createAsignaciones(Asignaciones Asignaciones) {
        return asignacionesRepository.save(Asignaciones);
    }

    // Actualizar Asignaciones
    public Asignaciones updateAsignaciones(Long id, Asignaciones asignaciones) {
        if (asignacionesRepository.existsById(id)) {
            asignaciones.setAsignacionesId(id);
            return asignacionesRepository.save(asignaciones);
        }
        return null; // O puedes lanzar una excepción si no existe el Asignaciones
    }

    // Eliminar Asignaciones
    public void deleteAsignaciones(Long id) {
        asignacionesRepository.deleteById(id);
    }

    // Filtrar Asignacioneses según varios atributos
    public List<Asignaciones> filter(Long becarioId, Long responsableId, Status status) {
        if (responsableId != null && status != null && becarioId != null) {
            return asignacionesRepository.findByResponsable_IdAndStatusAndBecario_Id(responsableId, status, becarioId);
        } else if (responsableId != null && status != null) {
            return asignacionesRepository.findByResponsable_IdAndStatus(responsableId, status);
        } else if (becarioId != null) {
            return asignacionesRepository.findByBecario_Id(becarioId);
        } else if (responsableId != null) {
            return asignacionesRepository.findByResponsable_Id(responsableId);
        } else if (status != null) {
            return asignacionesRepository.findByStatus(status);
        } else {
            return asignacionesRepository.findAll(); // Si no hay filtros, devuelve todos los Asignacioneses
        }
    }
}
