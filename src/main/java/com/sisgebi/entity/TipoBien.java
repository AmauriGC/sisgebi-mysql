package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_bien")
public class TipoBien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoBienId;

    @NotBlank(message = "El nombre del tipo de bien es obligatorio")
    @Column(name = "nombre_tipo_bien", nullable = false, unique = true)
    private String nombreTipoBien;

    @NotNull(message = "El estado del tipo de bien es obligatorio")
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

    // Getters y setters
    public Long getTipoBienId() {
        return tipoBienId;
    }

    public void setTipoBienId(Long tipoBienId) {
        this.tipoBienId = tipoBienId;
    }

    public String getNombreTipoBien() {
        return nombreTipoBien;
    }

    public void setNombreTipoBien(String nombreTipoBien) {
        this.nombreTipoBien = nombreTipoBien;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
