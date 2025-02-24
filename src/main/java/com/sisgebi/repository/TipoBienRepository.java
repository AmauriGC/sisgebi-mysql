package com.sisgebi.repository;

import com.sisgebi.entity.TipoBien;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoBienRepository extends JpaRepository<TipoBien, Long> {

    // Métodos personalizados para filtro
    List<TipoBien> findByNombreTipoBien(String nombreTipoBien);

    List<TipoBien> findByStatus(Status status);

    List<TipoBien> findByNombreTipoBienAndStatus(String nombreTipoBien, Status status);
}
