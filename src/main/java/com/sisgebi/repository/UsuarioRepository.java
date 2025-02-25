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

    List<Usuario> findByStatus(Status status);

    List<Usuario> findByRol(RolUsuario rol);

    List<Usuario> findByLugarContaining(String lugar);
}
