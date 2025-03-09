package com.sisgebi.service;

import com.sisgebi.entity.Bien;
import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.Disponibilidad;
import com.sisgebi.enums.Status;
import com.sisgebi.enums.TipoUbicacion;
import com.sisgebi.repository.BienRepository;
import jakarta.xml.ws.http.HTTPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BienService {

    @Autowired
    private BienRepository bienRepository;
    @Autowired
    private AreaComunService areaComunService;

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
        Optional<Bien> bienOptional = bienRepository.findById(id);
        if (bienOptional.isPresent()) {
            Bien bien = bienOptional.get();
            bien.setStatus(Status.INACTIVO); // Cambia el estado a INACTIVO
            bienRepository.save(bien); // Guarda el cambio en la base de datos
        } else {
            return;
        }
    }
    // Filtrar bienes según varios atributos
    public List<Bien> filter(Long tipoBienId, Long marcaId, Long modeloId, TipoUbicacion tipoUbicacion,
                             Long areaComunId, Long id, Status status, Disponibilidad disponibilidad) {
        return bienRepository.filter(tipoBienId, marcaId, modeloId, tipoUbicacion,areaComunId, id, status, disponibilidad);
    }
}
