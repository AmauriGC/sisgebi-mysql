package com.sisgebi.repository;

import com.sisgebi.entity.Modelo;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    // Métodos personalizados para filtros
    List<Modelo> findByNombreModelo(String nombreModelo);

    List<Modelo> findByStatus(Status status);

    List<Modelo> findByMarcaId(Long marcaId);

    List<Modelo> findByNombreModeloAndStatus(String nombreModelo, Status status);

    List<Modelo> findByNombreModeloAndStatusAndMarcaId(String nombreModelo, Status status, Long marcaId);
}
