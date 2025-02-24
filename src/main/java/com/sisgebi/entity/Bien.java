//package com.sisgebi.entity;
//
//import com.sisgebi.enums.EstadoBien;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "bien")
//public class Bien {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long bienId;
//
//    @ManyToOne
//    @JoinColumn(name = "tipo_bien_id", nullable = false)
//    private TipoBien tipoBien;
//
//    @ManyToOne
//    @JoinColumn(name = "marca_id", nullable = false)
//    private Marca marca;
//
//    @ManyToOne
//    @JoinColumn(name = "modelo_id", nullable = false)
//    private Modelo modelo;
//
//    @NotBlank(message = "El número de serie es obligatorio")
//    @Column(name = "numero_serie", nullable = false, unique = true)
//    private String numeroSerie;
//
//    @NotBlank(message = "El código del bien es obligatorio")
//    @Column(name = "codigo", nullable = false, unique = true)
//    private String codigo;
//
//    @ManyToOne
//    @JoinColumn(name = "ubicacion_actual_id", nullable = false)
//    private Ubicacion ubicacionActual;
//
//    @ManyToOne
//    @JoinColumn(name = "responsable_id", nullable = false)
//    private Usuario responsable;
//
//    @NotNull(message = "El estado del bien es obligatorio")
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private EstadoBien estadoBien;
//
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    // Getters y setters
//    public Long getBienId() {
//        return bienId;
//    }
//
//    public void setBienId(Long bienId) {
//        this.bienId = bienId;
//    }
//
//    public TipoBien getTipoBien() {
//        return tipoBien;
//    }
//
//    public void setTipoBien(TipoBien tipoBien) {
//        this.tipoBien = tipoBien;
//    }
//
//    public Marca getMarca() {
//        return marca;
//    }
//
//    public void setMarca(Marca marca) {
//        this.marca = marca;
//    }
//
//    public Modelo getModelo() {
//        return modelo;
//    }
//
//    public void setModelo(Modelo modelo) {
//        this.modelo = modelo;
//    }
//
//    public String getNumeroSerie() {
//        return numeroSerie;
//    }
//
//    public void setNumeroSerie(String numeroSerie) {
//        this.numeroSerie = numeroSerie;
//    }
//
//    public String getCodigo() {
//        return codigo;
//    }
//
//    public void setCodigo(String codigo) {
//        this.codigo = codigo;
//    }
//
//    public Ubicacion getUbicacionActual() {
//        return ubicacionActual;
//    }
//
//    public void setUbicacionActual(Ubicacion ubicacionActual) {
//        this.ubicacionActual = ubicacionActual;
//    }
//
//    public Usuario getResponsable() {
//        return responsable;
//    }
//
//    public void setResponsable(Usuario responsable) {
//        this.responsable = responsable;
//    }
//
//    public EstadoBien getEstadoBien() {
//        return estadoBien;
//    }
//
//    public void setEstadoBien(EstadoBien estadoBien) {
//        this.estadoBien = estadoBien;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//}
