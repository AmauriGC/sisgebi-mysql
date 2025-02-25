package com.sisgebi.service;

import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.RolUsuario;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener usuario por id
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Crear un nuevo usuario
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar usuario
    public Usuario updateUsuario(Long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null; // O puedes lanzar una excepción
    }

    // Eliminar usuario
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Filtros
    public List<Usuario> filter(Boolean filterStatus, Boolean filterRol, Boolean filterLugar) {
        // Si el filtro de status está habilitado
        if (filterStatus != null && filterStatus) {
            return usuarioRepository.findByStatus(Status.ACTIVO);  // O cualquier lógica que aplique para activo
        }

        // Si el filtro de rol está habilitado
        if (filterRol != null && filterRol) {
            return usuarioRepository.findByRol(RolUsuario.ADMINISTRADOR);  // O cualquier lógica que aplique para rol
        }

        // Si el filtro de lugar está habilitado
        if (filterLugar != null && filterLugar) {
            return usuarioRepository.findByLugarContaining("Oficina");  // O cualquier lógica que aplique para lugar
        }

        // Si no se seleccionan filtros, se devuelven todos los usuarios
        return usuarioRepository.findAll();
    }
}