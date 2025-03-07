package com.sisgebi.repository;

import com.sisgebi.entity.Bien;
import com.sisgebi.enums.Disponibilidad;
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

    // Filtrar por tipo de ubicación (enum)
    List<Bien> findByTipoUbicacion(TipoUbicacion tipoUbicacion);


    // Filtrar por área común (id del área común)
    List<Bien> findByAreaComun_AreaId(Long areaComunId);

    // Filtrar por tipo de bien (id del tipo de bien)
    List<Bien> findByTipoBien_TipoBienId(Long tipoBienId);

    // Filtrar por marca (id de la marca)
    List<Bien> findByMarca_MarcaId(Long marcaId);

    // Filtrar por modelo (id del modelo)
    List<Bien> findByModelo_ModeloId(Long modeloId);


    // Filtrar por estado
    List<Bien> findByStatus(Status status);

    // Filtrar por disponibilidad
    List<Bien> findByDisponibilidad(Disponibilidad disponibilidad);

    // Filtrar por estado y disponibilidad
    List<Bien> findByStatusAndDisponibilidad(Status status, Disponibilidad disponibilidad);


    // Filtrar por área común y disponibilidad
    List<Bien> findByAreaComun_AreaIdAndDisponibilidad(Long areaComunId, Disponibilidad disponibilidad);

    // Filtrar por área común y disponibilidad y estatus
    List<Bien> findByAreaComun_AreaIdAndDisponibilidadAndStatus(Long areaComunId, Disponibilidad disponibilidad, Status status);

    @Query("SELECT DISTINCT b.tipoUbicacion FROM Bien b")
    List<TipoUbicacion> findDistinctTipoUbicacion();

    @Query("SELECT DISTINCT b.codigo FROM Bien b")
    List<String> findDistinctCodigo();

    @Query("SELECT DISTINCT b.numeroSerie FROM Bien b")
    List<String> findDistinctNumeroSerie();
}
