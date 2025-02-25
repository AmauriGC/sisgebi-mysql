package com.sisgebi.entity;

import com.sisgebi.enums.RolUsuario;
import com.sisgebi.enums.TipoUbicacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "ubicacion")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ubicacionId;

    @NotNull(message = "El tipo de ubicación es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUbicacion tipoUbicacion;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    @NotNull
    private AreaComun areaComun;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @NotNull
    private Usuario becario;

    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Validación: El usuario debe ser BECARIO
    public void setBecario(Usuario becario) {
        if (becario.getRol() != RolUsuario.BECARIO) {
            throw new IllegalArgumentException("El usuario debe tener el rol BECARIO");
        }
        this.becario = becario;
    }

    public Long getUbicacionId() {
        return ubicacionId;
    }

    public void setUbicacionId(Long ubicacionId) {
        this.ubicacionId = ubicacionId;
    }

    public TipoUbicacion getTipoUbicacion() {
        return tipoUbicacion;
    }

    public void setTipoUbicacion(TipoUbicacion tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }

    public AreaComun getAreaComun() {
        return areaComun;
    }

    public void setAreaComun(AreaComun areaComun) {
        this.areaComun = areaComun;
    }

    public Usuario getBecario() {
        return becario;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
