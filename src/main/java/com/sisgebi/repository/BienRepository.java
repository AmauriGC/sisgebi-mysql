package com.sisgebi.repository;

import com.sisgebi.entity.Bien;
import com.sisgebi.enums.Disponibilidad;
import com.sisgebi.enums.Status;
import com.sisgebi.enums.TipoUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long> {

    @Query("SELECT DISTINCT b.tipoUbicacion FROM Bien b")
    List<TipoUbicacion> findDistinctTipoUbicacion();

    @Query("SELECT DISTINCT b.codigo FROM Bien b")
    List<String> findDistinctCodigo();

    @Query("SELECT DISTINCT b.numeroSerie FROM Bien b")
    List<String> findDistinctNumeroSerie();


    @Query("SELECT b FROM Bien b WHERE " +
            "(:tipoBienId IS NULL OR b.tipoBien.tipoBienId = :tipoBienId) AND " +
            "(:marcaId IS NULL OR b.marca.marcaId = :marcaId) AND " +
            "(:modeloId IS NULL OR b.modelo.modeloId = :modeloId) AND " +
            "(:tipoUbicacion IS NULL OR b.tipoUbicacion = :tipoUbicacion) AND " +
            "(:areaComunId IS NULL OR b.areaComun.areaId = :areaComunId) AND " +
            "(:id IS NULL OR b.usuario.id = :id) AND " +
            "(:status IS NULL OR b.status = :status) AND " +
            "(:disponibilidad IS NULL OR b.disponibilidad = :disponibilidad)")
    List<Bien> filter(
            @Param("tipoBienId") Long tipoBienId,
            @Param("marcaId") Long marcaId,
            @Param("modeloId") Long modeloId,
            @Param("tipoUbicacion") TipoUbicacion tipoUbicacion,
            @Param("areaComunId") Long areaComunId,
            @Param("id") Long id,
            @Param("status") Status status,
            @Param("disponibilidad") Disponibilidad disponibilidad
    );
}
