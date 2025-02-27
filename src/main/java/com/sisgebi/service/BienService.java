package com.sisgebi.service;

import com.sisgebi.entity.Bien;
import com.sisgebi.enums.Status;
import com.sisgebi.enums.TipoUbicacion;
import com.sisgebi.repository.BienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BienService {

    @Autowired
    private BienRepository bienRepository;

    public BienService(BienRepository bienRepository) {
        this.bienRepository = bienRepository;
    }

    // Obtener todos los bienes
    public List<Bien> getAllBienes() {
        return bienRepository.findAll();
    }

    // Obtener bien por id
    public Optional<Bien> getBienById(Long id) {
        return bienRepository.findById(id);
    }

    // Crear un nuevo bien
    public Bien createBien(Bien bien) {
        return bienRepository.save(bien);
    }

    // Actualizar bien
    public Bien updateBien(Long id, Bien bien) {
        if (bienRepository.existsById(id)) {
            bien.setIdBien(id);
            return bienRepository.save(bien);
        }
        return null; // O puedes lanzar una excepción si no existe el bien
    }

    // Eliminar bien
    public void deleteBien(Long id) {
        bienRepository.deleteById(id);
    }

    // Filtrar bienes según varios atributos
    public List<Bien> filter(String codigo, String numeroSerie, Long tipoBienId, Long marcaId, Long modeloId,
                             TipoUbicacion tipoUbicacion, Long areaComunId, Status status) {
        if (codigo != null) {
            return bienRepository.findByCodigo(codigo);
        } else if (numeroSerie != null) {
            return bienRepository.findByNumeroSerie(numeroSerie);
        } else if (tipoBienId != null) {
            return bienRepository.findByTipoBien_TipoBienId(tipoBienId);
        } else if (marcaId != null) {
            return bienRepository.findByMarca_MarcaId(marcaId);
        } else if (modeloId != null) {
            return bienRepository.findByModelo_ModeloId(modeloId);
        } else if (tipoUbicacion != null) {
            return bienRepository.findByTipoUbicacion(tipoUbicacion);
        } else if (areaComunId != null) {
            return bienRepository.findByAreaComun_AreaId(areaComunId);
        } else if (status != null) {
            return bienRepository.findByStatus(status);
        } else {
            return bienRepository.findAll(); // Si no hay filtros, devuelve todos los bienes
        }
    }
}
