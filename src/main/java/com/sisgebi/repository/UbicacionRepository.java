package com.sisgebi.repository;

import com.sisgebi.entity.Ubicacion;
import com.sisgebi.enums.TipoUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {

    // Métodos personalizados para los filtros
    List<Ubicacion> findByTipoUbicacion(TipoUbicacion tipoUbicacion);

    List<Ubicacion> findByAreaComun_AreaId(Long areaId); // Antes: findByAreaComun_Id

    List<Ubicacion> findByBecario_Id(Long becarioId); // Este ya estaba correcto

    List<Ubicacion> findByTipoUbicacionAndAreaComun_AreaIdAndBecario_Id(TipoUbicacion tipoUbicacion, Long areaId, Long becarioId); // Antes: findByTipoUbicacionAndAreaComun_IdAndBecario_Id

    List<Ubicacion> findByTipoUbicacionAndAreaComun_AreaId(TipoUbicacion tipoUbicacion, Long areaId); // Antes: findByTipoUbicacionAndAreaComun_Id

    List<Ubicacion> findByTipoUbicacionAndBecario_Id(TipoUbicacion tipoUbicacion, Long becarioId);

    List<Ubicacion> findByAreaComun_AreaIdAndBecario_Id(Long areaId, Long becarioId); // Antes: findByAreaComun_IdAndBecario_Id
}
