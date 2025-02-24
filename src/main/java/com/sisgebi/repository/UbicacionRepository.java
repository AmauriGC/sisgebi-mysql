package com.sisgebi.repository;

import com.sisgebi.entity.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {

    // Métodos personalizados para los filtros
    List<Ubicacion> findByTipoUbicacion(String tipoUbicacion);

    List<Ubicacion> findByAreaComun_AreaId(Long areaId);

    List<Ubicacion> findByBecario_UsuarioId(Long usuarioId);

    List<Ubicacion> findByTipoUbicacionAndAreaComun_AreaIdAndBecario_UsuarioId(String tipoUbicacion, Long areaId, Long usuarioId);

    List<Ubicacion> findByTipoUbicacionAndAreaComun_AreaId(String tipoUbicacion, Long areaId);

    List<Ubicacion> findByTipoUbicacionAndBecario_UsuarioId(String tipoUbicacion, Long usuarioId);

    List<Ubicacion> findByAreaComun_AreaIdAndBecario_UsuarioId(Long areaId, Long usuarioId);
}
