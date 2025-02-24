package com.sisgebi.repository;

import com.sisgebi.entity.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long> {

    // Métodos personalizados para los filtros
    List<Bien> findByTipoBien_TipoBienIdAndMarca_MarcaIdAndModelo_ModeloIdAndNumeroSerieAndCodigo(
            Long tipoBienId, Long marcaId, Long modeloId, String numeroSerie, String codigo);

    List<Bien> findByTipoBien_TipoBienIdAndMarca_MarcaIdAndModelo_ModeloId(Long tipoBienId, Long marcaId, Long modeloId);

    List<Bien> findByNumeroSerie(String numeroSerie);

    List<Bien> findByCodigo(String codigo);
}
