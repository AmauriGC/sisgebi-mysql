package com.sisgebi.repository;

import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.RolUsuario;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);

    // Filtro por nombres, apellidos, rol y estado
    List<Usuario> findByNombresAndStatus(String nombres, Status status);

    List<Usuario> findByApellidosAndStatus(String apellidos, Status status);

    List<Usuario> findByNombresAndApellidosAndStatus(String nombres, String apellidos, Status status);

    List<Usuario> findByRolAndStatus(RolUsuario rol, Status status);

    List<Usuario> findByStatus(Status status);

    List<Usuario> findByNombres(String nombres);

    List<Usuario> findByApellidos(String apellidos);

    List<Usuario> findByRol(RolUsuario rol);
}
