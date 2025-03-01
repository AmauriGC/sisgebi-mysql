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

    public List<Usuario> getResponsables() {
        return usuarioRepository.findByRol(RolUsuario.RESPONSABLE);
    }

    // Filtrar usuarios según `Status`, `RolUsuario` y `Lugar`
    public List<Usuario> filter(Status status, RolUsuario rol, String lugar) {
        if (status != null && rol != null && lugar != null) {
            return usuarioRepository.findByRolAndStatusAndLugar(rol, status, lugar);
        } else if (status != null && rol != null) {
            return usuarioRepository.findByRolAndStatus(rol, status);
        } else if (status != null && lugar != null) {
            return usuarioRepository.findByStatusAndLugar(status, lugar);
        } else if (rol != null && lugar != null) {
            return usuarioRepository.findByRolAndLugar(rol, lugar);
        } else if (status != null) {
            return usuarioRepository.findByStatus(status);
        } else if (rol != null) {
            return usuarioRepository.findByRol(rol);
        } else if (lugar != null) {
            return usuarioRepository.findByLugar(lugar);
        } else {
            return usuarioRepository.findAll();
        }
    }
}