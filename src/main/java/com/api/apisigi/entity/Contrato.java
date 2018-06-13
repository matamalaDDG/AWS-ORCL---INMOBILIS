package com.api.apisigi.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO CONTRATO
@Entity
public class Contrato {
    private String idContrato;
    private String descripcion;
    private Time fechaInico;
    private Time fechaFin;
    private Collection<CapacidadEconomica> capacidadeconomica;
    private Documento tbldocumento;

    @Id
    @Column(name = "ID_CONTRATO")
    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "FECHA_INICO")
    public Time getFechaInico() {
        return fechaInico;
    }

    public void setFechaInico(Time fechaInico) {
        this.fechaInico = fechaInico;
    }

    @Basic
    @Column(name = "FECHA_FIN")
    public Time getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Time fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return Objects.equals(idContrato, contrato.idContrato) &&
                Objects.equals(descripcion, contrato.descripcion) &&
                Objects.equals(fechaInico, contrato.fechaInico) &&
                Objects.equals(fechaFin, contrato.fechaFin);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idContrato, descripcion, fechaInico, fechaFin);
    }

    @OneToMany(mappedBy = "contrato")
    public Collection<CapacidadEconomica> getCapacidadeconomica() {
        return capacidadeconomica;
    }

    public void setCapacidadeconomica(Collection<CapacidadEconomica> capacidadeconomica) {
        this.capacidadeconomica = capacidadeconomica;
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false)
    public Documento getTbldocumento() {
        return tbldocumento;
    }

    public void setTbldocumento(Documento tbldocumento) {
        this.tbldocumento = tbldocumento;
    }
}
