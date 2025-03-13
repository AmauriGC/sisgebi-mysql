package com.sisgebi.entity;

import com.sisgebi.enums.Disponibilidad;
import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "bien")
public class Bien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bienId;

    @NotBlank(message = "El código del bien es obligatorio")
    @Column(nullable = false, unique = true)
    private String codigo;

    @NotBlank(message = "El número de serie es obligatorio")
    @Column(nullable = false, unique = true)
    private String numeroSerie;

    @ManyToOne
    @JoinColumn(name = "id_tipo_bien", nullable = false)
    private TipoBien tipoBien;

    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_modelo", nullable = false)
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "id_area_comun", nullable = true)
    private AreaComun areaComun;

    @NotNull(message = "El estado del bien es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @NotNull(message = "La disponibilidad del bien es obligatoria")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Disponibilidad disponibilidad;

    @Column(nullable = false)
    private String motivo;

    public Long getBienId() {
        return bienId;
    }

    public void setBienId(Long bienId) {
        this.bienId = bienId;
    }

    public @NotBlank(message = "El código del bien es obligatorio") String getCodigo() {
        return codigo;
    }

    public void setCodigo(@NotBlank(message = "El código del bien es obligatorio") String codigo) {
        this.codigo = codigo;
    }

    public @NotBlank(message = "El número de serie es obligatorio") String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(@NotBlank(message = "El número de serie es obligatorio") String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public TipoBien getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(TipoBien tipoBien) {
        this.tipoBien = tipoBien;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public AreaComun getAreaComun() {
        return areaComun;
    }

    public void setAreaComun(AreaComun areaComun) {
        this.areaComun = areaComun;
    }

    public @NotNull(message = "El estado del bien es obligatorio") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "El estado del bien es obligatorio") Status status) {
        this.status = status;
    }

    public @NotNull(message = "La disponibilidad del bien es obligatoria") Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(@NotNull(message = "La disponibilidad del bien es obligatoria") Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public @NotNull(message = "El motivo debe de ser obligatorio") String getMotivo() {
        return motivo;
    }

    public void setMotivo(@NotNull(message = "El motivo debe de ser obligatorio") String motivo) {
        this.motivo = motivo;
    }
}
