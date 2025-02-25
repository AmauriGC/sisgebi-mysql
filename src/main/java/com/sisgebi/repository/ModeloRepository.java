package com.sisgebi.repository;

import com.sisgebi.entity.Marca;
import com.sisgebi.entity.Modelo;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    // Filtrar por estado
    List<Modelo> findByStatus(Status status);

    // Filtrar por marca
    List<Modelo> findByMarca(Marca marca);

    // Filtrar por estado y marca combinados
    List<Modelo> findByStatusAndMarca(Status status, Marca marca);
}
