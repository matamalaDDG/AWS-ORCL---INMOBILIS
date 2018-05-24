package com.api.apisigi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Contrato {
    private String idContrato;
    private String descripcion;
    private Time fechaInico;
    private Time fechaFin;
    private String documento;
    private String idDocumento;

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

    @Basic
    @Column(name = "DOCUMENTO")
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Basic
    @Column(name = "ID_DOCUMENTO")
    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return Objects.equals(idContrato, contrato.idContrato) &&
                Objects.equals(descripcion, contrato.descripcion) &&
                Objects.equals(fechaInico, contrato.fechaInico) &&
                Objects.equals(fechaFin, contrato.fechaFin) &&
                Objects.equals(documento, contrato.documento) &&
                Objects.equals(idDocumento, contrato.idDocumento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idContrato, descripcion, fechaInico, fechaFin, documento, idDocumento);
    }
}
