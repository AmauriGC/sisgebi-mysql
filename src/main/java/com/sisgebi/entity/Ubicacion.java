package com.sisgebi.entity;

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

    // Getters y setters
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

    public void setBecario(Usuario becario) {
        this.becario = becario;
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
