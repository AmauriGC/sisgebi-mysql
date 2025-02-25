package com.sisgebi.repository;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaComunRepository extends JpaRepository<AreaComun, Long> {

    List<AreaComun> findByStatus(Status status);
}
