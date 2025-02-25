package com.sisgebi.repository;

import com.sisgebi.entity.TipoBien;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoBienRepository extends JpaRepository<TipoBien, Long> {

    List<TipoBien> findByStatus(Status status);
}
