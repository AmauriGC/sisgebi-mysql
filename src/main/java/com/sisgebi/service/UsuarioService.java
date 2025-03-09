package com.sisgebi.service;

import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.RolUsuario;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // Importar PasswordEncoder
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        // Hashear la contraseña antes de guardar
        String hashedPassword = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(hashedPassword);
        return usuarioRepository.save(usuario);
    }

    // Actualizar usuario
    public Usuario updateUsuario(Long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            // Obtener el usuario existente
            Optional<Usuario> existingUsuarioOptional = usuarioRepository.findById(id);
            if (existingUsuarioOptional.isPresent()) {
                Usuario existingUsuario = existingUsuarioOptional.get();

                // Actualizar campos
                existingUsuario.setNombres(usuario.getNombres());
                existingUsuario.setApellidos(usuario.getApellidos());
                existingUsuario.setCorreo(usuario.getCorreo());
                existingUsuario.setLugar(usuario.getLugar());
                existingUsuario.setRol(usuario.getRol());
                existingUsuario.setStatus(usuario.getStatus());

                // Si se proporciona una nueva contraseña, hashearla
                if (usuario.getContrasena() != null && !usuario.getContrasena().isEmpty()) {
                    String hashedPassword = passwordEncoder.encode(usuario.getContrasena());
                    existingUsuario.setContrasena(hashedPassword);
                }

                return usuarioRepository.save(existingUsuario);
            }
        }
        return null; // O puedes lanzar una excepción
    }

    // Eliminar usuario
    public void deleteUsuario(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setStatus(Status.INACTIVO);
            usuarioRepository.save(usuario);
        } else {
            return;
        }
    }

    public List<Usuario> getResponsables() {
        return usuarioRepository.findByRol(RolUsuario.RESPONSABLE);
    }

    public List<Usuario> getBecarios() {
        return usuarioRepository.findByRol(RolUsuario.BECARIO);
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