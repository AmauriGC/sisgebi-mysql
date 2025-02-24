package com.sisgebi.repository;

import com.sisgebi.entity.Marca;
import com.sisgebi.entity.Modelo;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    List<Modelo> findByNombreModelo(String nombreModelo);

    List<Modelo> findByStatus(Status status);

    List<Modelo> findByMarca(Marca marca);

    List<Modelo> findByNombreModeloAndStatus(String nombreModelo, Status status);

    List<Modelo> findByMarcaAndNombreModeloAndStatus(Marca marca, String nombreModelo, Status status);

    List<Modelo> findByMarcaAndNombreModelo(Marca marca, String nombreModelo);

    List<Modelo> findByMarcaAndStatus(Marca marca, Status status);
}
