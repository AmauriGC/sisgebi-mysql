package com.sisgebi.repository;

import com.sisgebi.entity.Bien;
import com.sisgebi.enums.Status;
import com.sisgebi.enums.TipoUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long> {

    // Filtrar por código
    List<Bien> findByCodigo(String codigo);

    // Filtrar por número de serie
    List<Bien> findByNumeroSerie(String numeroSerie);

    // Filtrar por tipo de bien (id del tipo de bien)
    List<Bien> findByTipoBien_TipoBienId(Long tipoBienId);

    // Filtrar por marca (id de la marca)
    List<Bien> findByMarca_MarcaId(Long marcaId);

    // Filtrar por modelo (id del modelo)
    List<Bien> findByModelo_ModeloId(Long modeloId);

    // Filtrar por tipo de ubicación (enum)
    List<Bien> findByTipoUbicacion(TipoUbicacion tipoUbicacion);

    // Filtrar por área común (id del área común)
    List<Bien> findByAreaComun_AreaId(Long areaComunId);

    // Filtrar por becario (id del becario)
    List<Bien> findByBecario_Id(Long becarioId);

    // Filtrar por responsable (id del responsable)
    List<Bien> findByResponsable_Id(Long responsableId);

    // Filtrar por estado
    List<Bien> findByStatus(Status status);

    // Filtrar combinando código y número de serie
    List<Bien> findByCodigoAndNumeroSerie(String codigo, String numeroSerie);

    // Filtrar combinando tipo de bien y marca
    List<Bien> findByTipoBien_TipoBienIdAndMarca_MarcaId(Long tipoBienId, Long marcaId);

    // Filtrar combinando responsable y estado
    List<Bien> findByResponsable_IdAndStatus(Long responsableId, Status status);

    // Filtro combinado por todos los atributos posibles
    List<Bien> findByCodigoAndNumeroSerieAndTipoBien_TipoBienIdAndMarca_MarcaIdAndModelo_ModeloIdAndTipoUbicacionAndAreaComun_AreaIdAndBecario_IdAndResponsable_IdAndStatus(
            String codigo, String numeroSerie, Long tipoBienId, Long marcaId, Long modeloId, TipoUbicacion tipoUbicacion,
            Long areaComunId, Long becarioId, Long responsableId, Status status
    );

    @Query("SELECT DISTINCT b.tipoUbicacion FROM Bien b")
    List<TipoUbicacion> findDistinctTipoUbicacion();

    @Query("SELECT DISTINCT b.codigo FROM Bien b")
    List<String> findDistinctCodigo();

    @Query("SELECT DISTINCT b.numeroSerie FROM Bien b")
    List<String> findDistinctNumeroSerie();
}
