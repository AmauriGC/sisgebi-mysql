package com.sisgebi.repository;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.entity.Marca;
import com.sisgebi.entity.Modelo;
import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaComunRepository extends JpaRepository<AreaComun, Long> {

    // Filtrar por ID de área y estado
    List<AreaComun> findByareaIdAndStatus(Long areaId, Status status);

    // Filtrar solo por estado
    List<AreaComun> findByStatus(Status status);

    // Filtrar por usuario
    List<AreaComun> findByResponsable(Usuario responsable);
}
