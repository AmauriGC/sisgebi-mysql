package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "asignaciones")
public class Asignaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asignacionesId;

    // puedo poner en otra tabla para asignaciones
    @ManyToOne
    @JoinColumn(name = "id_becario", nullable = true)
    private Usuario becario;

    @ManyToOne
    @JoinColumn(name = "id_responsable", nullable = false)
    private Usuario responsable;
    // para revisar como se maneja

    @NotNull(message = "El estado del bien es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

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

    public Long getAsignacionesId() {
        return asignacionesId;
    }

    public void setAsignacionesId(Long asignacionesId) {
        this.asignacionesId = asignacionesId;
    }

    public Usuario getBecario() {
        return becario;
    }

    public void setBecario(Usuario becario) {
        this.becario = becario;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
