package com.sisgebi.service;

import com.sisgebi.entity.Asignaciones;
import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.RolUsuario;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.AsignacionesRepository;
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

    // Validar que el usuario no sea ADMINISTRADOR
    private void validarUsuario(Usuario usuario) {
        if (usuario.getRol() == RolUsuario.ADMINISTRADOR) {
            throw new RuntimeException("No se puede asignar a un ADMINISTRADOR");
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

    // Crear una nueva asignación (solo para RESPONSABLES y BECARIOS)
    public Asignaciones createAsignacion(Asignaciones asignacion) {
        Usuario usuario = asignacion.getUsuario();
        validarUsuario(usuario); // Validar que no sea ADMINISTRADOR
        return asignacionesRepository.save(asignacion);
    }

    // Actualizar una asignación (solo para RESPONSABLES y BECARIOS)
    public Asignaciones updateAsignacion(Long id, Asignaciones asignacion) {
        if (asignacionesRepository.existsById(id)) {
            Usuario usuario = asignacion.getUsuario();
            validarUsuario(usuario); // Validar que no sea ADMINISTRADOR
            asignacion.setAsignacionesId(id);
            return asignacionesRepository.save(asignacion);
        }
        return null; // O lanzar una excepción
    }

    // Eliminar una asignación
    public void delete(Long id) {
        Optional<Asignaciones> asignacionesOptional = asignacionesRepository.findById(id);
        if (asignacionesOptional.isPresent()) {
            Asignaciones asignaciones = asignacionesOptional.get();
            asignaciones.setStatus(Status.INACTIVO); // Cambia el estado a INACTIVO
            asignacionesRepository.save(asignaciones); // Guarda el cambio en la base de datos
        } else {
            return;
        }
    }

    // Filtrar usuarios según `Status`, `RolUsuario` y `Lugar`
    public List<Asignaciones> filter(Status status) {
        if (status != null) {
            return asignacionesRepository.findByStatus(status);
        } else {
            return asignacionesRepository.findAll();
        }
    }
}