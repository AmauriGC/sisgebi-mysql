package com.sisgebi.service;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.entity.Ubicacion;
import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.RolUsuario;
import com.sisgebi.enums.TipoUbicacion;
import com.sisgebi.repository.AreaComunRepository;
import com.sisgebi.repository.UbicacionRepository;
import com.sisgebi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Autowired
    private AreaComunRepository areaComunRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todas las ubicaciones
    public List<Ubicacion> getAll() {
        return ubicacionRepository.findAll();
    }

    // Obtener ubicación por ID
    public Optional<Ubicacion> getById(Long id) {
        return ubicacionRepository.findById(id);
    }

    // Guardar o actualizar una ubicación (validando que el usuario sea BECARIO)
    public Ubicacion save(Ubicacion ubicacion) {
        if (ubicacion.getBecario().getRol() != RolUsuario.BECARIO) {
            throw new IllegalArgumentException("El usuario debe tener el rol BECARIO");
        }
        return ubicacionRepository.save(ubicacion);
    }

    // Actualizar una ubicación existente (con validación de BECARIO)
    public Ubicacion update(Long id, Ubicacion ubicacion) {
        if (!ubicacionRepository.existsById(id)) {
            throw new IllegalArgumentException("La ubicación con ID " + id + " no existe.");
        }

        if (ubicacion.getBecario().getRol() != RolUsuario.BECARIO) {
            throw new IllegalArgumentException("El usuario debe tener el rol BECARIO.");
        }

        ubicacion.setUbicacionId(id);
        return ubicacionRepository.save(ubicacion);
    }

    // Eliminar ubicación con verificación previa
    public void delete(Long id) {
        if (!ubicacionRepository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar, la ubicación con ID " + id + " no existe.");
        }
        ubicacionRepository.deleteById(id);
    }

    // Filtrar ubicaciones por TipoUbicacion, AreaComun, Becario y Status
    public List<Ubicacion> filter(TipoUbicacion tipoUbicacion, Long areaId, Long becarioId, Boolean status) {
        if (tipoUbicacion != null && areaId != null && becarioId != null) {
            Optional<AreaComun> area = areaComunRepository.findById(areaId);
            Optional<Usuario> becario = usuarioRepository.findById(becarioId);
            if (area.isPresent() && becario.isPresent()) {
                return ubicacionRepository.findByTipoUbicacionAndAreaComunAndBecarioAndStatus(
                        tipoUbicacion, area.get(), becario.get(), status != null && status);
            }
        } else if (tipoUbicacion != null && areaId != null) {
            Optional<AreaComun> area = areaComunRepository.findById(areaId);
            if (area.isPresent()) {
                return ubicacionRepository.findByTipoUbicacionAndAreaComun(tipoUbicacion, area.get());
            }
        } else if (becarioId != null) {
            Optional<Usuario> becario = usuarioRepository.findById(becarioId);
            if (becario.isPresent()) {
                return ubicacionRepository.findByBecario(becario.get());
            }
        } else if (status != null) {
            return ubicacionRepository.findByStatus(status);
        }
        return ubicacionRepository.findAll(); // Si no hay filtros, trae todas las ubicaciones
    }
}
