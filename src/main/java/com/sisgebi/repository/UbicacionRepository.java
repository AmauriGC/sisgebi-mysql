package com.sisgebi.repository;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.entity.Ubicacion;
import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.TipoUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {

    // Filtrar por TipoUbicacion, AreaComun, Becario y Status
    List<Ubicacion> findByTipoUbicacionAndAreaComunAndBecario(
            TipoUbicacion tipoUbicacion, AreaComun areaComun, Usuario becario);

    // Filtrar por TipoUbicacion y AreaComun
    List<Ubicacion> findByTipoUbicacionAndAreaComun(TipoUbicacion tipoUbicacion, AreaComun areaComun);

    // Filtrar por Becario
    List<Ubicacion> findByBecario(Usuario becario);

}
