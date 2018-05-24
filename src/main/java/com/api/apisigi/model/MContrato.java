package com.api.apisigi.model;

import com.api.apisigi.entity.Contrato;

import com.api.apisigi.entity.Contrato;

import java.sql.Time;
import java.util.Objects;

public class MContrato {

    private String idContrato;
    private String descripcion;
    private Time fechaInico;
    private Time fechaFin;
    private String documento;
    private String idDocumento;

    public MContrato() {
    }

    public MContrato(Contrato contrato) {
        this.idContrato = contrato.getIdContrato();
        this.descripcion = contrato.getDescripcion();
        this.fechaInico = contrato.getFechaInico();
        this.fechaFin = contrato.getFechaFin();
        this.documento = contrato.getDocumento();
        this.idDocumento = contrato.getIdDocumento();
    }

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Time getFechaInico() {
        return fechaInico;
    }

    public void setFechaInico(Time fechaInico) {
        this.fechaInico = fechaInico;
    }

    public Time getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Time fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MContrato)) return false;
        MContrato mContrato = (MContrato) o;
        return Objects.equals(getIdContrato(), mContrato.getIdContrato()) &&
                Objects.equals(getDescripcion(), mContrato.getDescripcion()) &&
                Objects.equals(getFechaInico(), mContrato.getFechaInico()) &&
                Objects.equals(getFechaFin(), mContrato.getFechaFin()) &&
                Objects.equals(getDocumento(), mContrato.getDocumento()) &&
                Objects.equals(getIdDocumento(), mContrato.getIdDocumento());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdContrato(), getDescripcion(), getFechaInico(), getFechaFin(), getDocumento(), getIdDocumento());
    }

    @Override
    public String toString() {
        return "MContrato{" +
                "idContrato='" + idContrato + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInico=" + fechaInico +
                ", fechaFin=" + fechaFin +
                ", documento='" + documento + '\'' +
                ", idDocumento='" + idDocumento + '\'' +
                '}';
    }
}
