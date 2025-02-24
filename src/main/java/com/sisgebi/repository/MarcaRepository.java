package com.sisgebi.repository;

import com.sisgebi.entity.Marca;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    
    // Filtro por nombre y estado
    List<Marca> findByNombreMarcaAndStatus (String nombre, Status status);
    List<Marca> findByNombreMarca (String nombreMarca);
    List<Marca> findByStatus (Status status);
}
