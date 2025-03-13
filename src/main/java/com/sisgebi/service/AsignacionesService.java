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


    // Validar que el usuario no sea ADMINISTRADOR
    private void validarUsuario(Usuario usuario) {
        if (usuario.getRol() == RolUsuario.ADMINISTRADOR) {
            throw new RuntimeException("No se puede asignar a un ADMINISTRADOR");
        }
        if (usuario.getRol() == RolUsuario.RESPONSABLE) {
            throw new RuntimeException("No se puede asignar a un RESPONSABLE");
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
        Usuario usuario = asignacion.getBecario();
        validarUsuario(usuario); // Validar que no sea ADMINISTRADOR o RESPONSABLE

        Bien bien = asignacion.getBien();
        if (bien == null || bienRepository.findById(bien.getBienId()).isEmpty()) {
            throw new RuntimeException("El bien no existe.");
        }

        // Actualizar disponibilidad del bien a OCUPADO
        bien.setDisponibilidad(Disponibilidad.OCUPADO);
        bienRepository.save(bien); // Guardar el cambio en la base de datos

        return asignacionesRepository.save(asignacion);
    }

    // Actualizar una asignación (solo para RESPONSABLES y BECARIOS)
    public Asignaciones updateAsignacion(Long id, Asignaciones asignacion) {
        if (asignacionesRepository.existsById(id)) {
            Usuario usuario = asignacion.getBecario();
            validarUsuario(usuario); // Validar que no sea ADMINISTRADOR o RESPONSABLE
            asignacion.setAsignacionesId(id);
            return asignacionesRepository.save(asignacion);
        }
        return null; // O lanzar una excepción
    }

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
            return asignacionesRepository.findByStatusAndBecarioId(status, id);
        } else if (id != null) {
            return asignacionesRepository.findByBecarioId(id);
        } else if (status != null) {
            return asignacionesRepository.findByStatus(status);
        } else {
            return asignacionesRepository.findAll();
        }
    }

}