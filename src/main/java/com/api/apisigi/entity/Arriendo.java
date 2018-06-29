package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;
import java.util.Objects;


@Entity
public class Arriendo {
    private String idArriendo;
    private String notificacion;
    private Time fechaArriendo;
    private long monto;
    private Convenio convenio;
    private Aseguradora aseguradora;
    private CapacidadEconomica capacidadeconomica;
    private Precontrato precontrato;

    private List<Propiedad> propiedad;

    @Id
    @Column(name = "ID_ARRIENDO")
    public String getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(String idArriendo) {
        this.idArriendo = idArriendo;
    }

    @Basic
    @Column(name = "NOTIFICACION")
    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    @Basic
    @Column(name = "FECHA_ARRIENDO")
    public Time getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Time fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    @Basic
    @Column(name = "MONTO")
    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arriendo arriendo = (Arriendo) o;
        return monto == arriendo.monto &&
                Objects.equals(idArriendo, arriendo.idArriendo) &&
                Objects.equals(notificacion, arriendo.notificacion) &&
                Objects.equals(fechaArriendo, arriendo.fechaArriendo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idArriendo, notificacion, fechaArriendo, monto);
    }

    @ManyToOne
    @JsonManagedReference("convenio")
    @JoinColumn(name = "ID_CONVENIO", referencedColumnName = "ID_CONVENIO")
    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    @ManyToOne
    @JsonManagedReference("aseguradora")
    @JoinColumn(name = "ID_ASEGURADORA", referencedColumnName = "ID_ASEGURADORA")
    public Aseguradora getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(Aseguradora aseguradora) {
        this.aseguradora = aseguradora;
    }

    @ManyToOne
    @JsonManagedReference("capacidadeconomica")
    @JoinColumn(name = "ID_CAPACIDAD_ECONOMICA", referencedColumnName = "ID_CAPACIDAD_ECONOMICA", nullable = false)
    public CapacidadEconomica getCapacidadeconomica() {
        return capacidadeconomica;
    }

    public void setCapacidadeconomica(CapacidadEconomica capacidadeconomica) {
        this.capacidadeconomica = capacidadeconomica;
    }

    @ManyToOne
    @JsonManagedReference("precontrato")
    @JoinColumn(name = "ID_PRE_CONTRATO", referencedColumnName = "ID_PRE_CONTRATO")
    public Precontrato getPrecontrato() {
        return precontrato;
    }

    public void setPrecontrato(Precontrato precontrato) {
        this.precontrato = precontrato;
    }

    @JsonBackReference("propiedad")
    @OneToMany(mappedBy = "arriendo")
    public List<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(List<Propiedad> propiedad) {
        this.propiedad = propiedad;
    }
}
