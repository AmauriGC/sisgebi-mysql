package com.sisgebi.repository;

import com.sisgebi.entity.Asignaciones;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionesRepository extends JpaRepository<Asignaciones, Long> {

    // estos serian para asignaciones

    // Filtrar por estado
    List<Asignaciones> findByStatus(Status status);

    // Filtrar por becario (id del becario)
    List<Asignaciones> findByBecario_Id(Long becarioId);

    // Filtrar por responsable (id del responsable)
    List<Asignaciones> findByResponsable_Id(Long responsableId);

    // Filtrar combinando responsable y estado
    List<Asignaciones> findByResponsable_IdAndStatus(Long responsableId, Status status);

    // Filtrar combinado por todo
    List<Asignaciones> findByResponsable_IdAndStatusAndBecario_Id(Long responsableId, Status status, Long becarioId);

    // hasta aqui
}
