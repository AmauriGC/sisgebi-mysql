package com.sisgebi.repository;

import com.sisgebi.entity.Marca;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    // Filtrar por ID de marca y estado
    List<Marca> findByIdMarcaAndStatus(Long idMarca, Status status);

    // Filtrar solo por estado (cuando el checkbox de status está marcado)
    List<Marca> findByStatus(Status status);
}
