package com.sisgebi.service;

import com.sisgebi.entity.Asignaciones;
import com.sisgebi.entity.Bien;
import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.Disponibilidad;
import com.sisgebi.enums.RolUsuario;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.AsignacionesRepository;
import com.sisgebi.repository.BienRepository;
import com.sisgebi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AsignacionesService {

    @Autowired
    private AsignacionesRepository asignacionesRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BienRepository bienRepository;

    // Validar que el usuario sea BECARIO
    private void validarUsuario(Usuario usuario) {
        if (usuario.getRol() != RolUsuario.BECARIO) {
            throw new RuntimeException("Solo los usuarios con rol BECARIO pueden ser asignados a un bien.");
        }
    }

    // Obtener todas las asignaciones (excluyendo ADMINISTRADORES)
    public List<Asignaciones> getAllAsignaciones() {
        return asignacionesRepository.findAll();
    }

    // Obtener una asignación por ID
    public Asignaciones getAsignacionById(Long id) {
        return asignacionesRepository.findById(id).orElse(null);
    }

    // Crear una nueva asignación y actualizar la disponibilidad del bien
    public Asignaciones createAsignacion(Asignaciones asignacion) {
        Usuario usuario = asignacion.getUsuario();
        validarUsuario(usuario); // Validar que el usuario sea BECARIO

        Bien bien = asignacion.getBien();
        if (bien == null || bienRepository.findById(bien.getBienId()).isEmpty()) {
            throw new RuntimeException("El bien no existe.");
        }

        // Verificar si el bien ya está ocupado
        if (bien.getDisponibilidad() == Disponibilidad.OCUPADO) {
            throw new RuntimeException("El bien ya está ocupado.");
        }

        // Actualizar disponibilidad del bien a OCUPADO
        bien.setDisponibilidad(Disponibilidad.OCUPADO);
        bienRepository.save(bien); // Guardar el cambio en la base de datos

        return asignacionesRepository.save(asignacion);
    }

    // Actualizar una asignación (solo para RESPONSABLES y BECARIOS)
    public Asignaciones updateAsignacion(Long id, Asignaciones asignacion) {
        if (asignacionesRepository.existsById(id)) {
            Usuario usuario = asignacion.getUsuario();
            validarUsuario(usuario); // Validar que el usuario sea BECARIO
            asignacion.setAsignacionesId(id);
            return asignacionesRepository.save(asignacion);
        }
        return null; // O lanzar una excepción
    }

    // Eliminar una asignación y liberar el bien
    public void delete(Long id) {
        Optional<Asignaciones> asignacionesOptional = asignacionesRepository.findById(id);
        if (asignacionesOptional.isPresent()) {
            Asignaciones asignacion = asignacionesOptional.get();

            // Cambiar la asignación a INACTIVO
            asignacion.setStatus(Status.INACTIVO);
            asignacionesRepository.save(asignacion);

            // Recuperar el bien asociado y cambiar su disponibilidad a DISPONIBLE
            Bien bien = asignacion.getBien();
            if (bien != null) {
                bien.setDisponibilidad(Disponibilidad.DISPONIBLE);
                bienRepository.save(bien);
            }
        } else {
            throw new RuntimeException("No se encontró la asignación con el ID: " + id);
        }
    }

    // Filtrar asignaciones por usuario y/o estado
    public List<Asignaciones> filter(Long id, Status status) {
        if (id != null && status != null) {
            return asignacionesRepository.findByStatusAndUsuarioId(status, id);
        } else if (id != null) {
            return asignacionesRepository.findByUsuarioId(id);
        } else if (status != null) {
            return asignacionesRepository.findByStatus(status);
        } else {
            return asignacionesRepository.findAll();
        }
    }
}
