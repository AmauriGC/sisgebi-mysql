package com.sisgebi.repository;

import com.sisgebi.entity.Asignaciones;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionesRepository extends JpaRepository<Asignaciones, Long> {


    // Filtrar por estado
    List<Asignaciones> findByStatus(Status status);
}