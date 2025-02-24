package com.sisgebi.service;

import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.Status;
import com.sisgebi.enums.RolUsuario;
import com.sisgebi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuario> getById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    // Crear un nuevo usuario
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar un usuario existente
    public Usuario update(Long idUsuario, Usuario usuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            usuario.setId(idUsuario);
            return usuarioRepository.save(usuario);
        }
        return null; // O lanzar una excepción
    }

    // Eliminar un usuario por ID
    public boolean delete(Long idUsuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            usuarioRepository.deleteById(idUsuario);
            return true;
        }
        return false; // O lanzar una excepción
    }

    // Filtro para usuarios
    public List<Usuario> filter(String nombres, String apellidos, RolUsuario rol, Status status) {
        if (nombres != null && apellidos != null && rol != null && status != null) {
            return usuarioRepository.findByNombresAndApellidosAndStatus(nombres, apellidos, status);
        } else if (nombres != null && status != null) {
            return usuarioRepository.findByNombresAndStatus(nombres, status);
        } else if (apellidos != null && status != null) {
            return usuarioRepository.findByApellidosAndStatus(apellidos, status);
        } else if (rol != null && status != null) {
            return usuarioRepository.findByRolAndStatus(rol, status);
        } else if (status != null) {
            return usuarioRepository.findByStatus(status);
        } else if (nombres != null) {
            return usuarioRepository.findByNombres(nombres);
        } else if (apellidos != null) {
            return usuarioRepository.findByApellidos(apellidos);
        } else if (rol != null) {
            return usuarioRepository.findByRol(rol);
        } else {
            return usuarioRepository.findAll();
        }
    }
}
