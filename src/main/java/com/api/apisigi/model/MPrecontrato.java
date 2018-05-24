package com.api.apisigi.model;

import com.api.apisigi.entity.Precontrato;

import java.util.Objects;

public class MPrecontrato {

    private String idPreContrato;
    private String estado;
    private String descripcion;
    private String documento;
    private String idDocumento;

    public MPrecontrato() {
    }

    public MPrecontrato(Precontrato precontrato) {
        this.idPreContrato = precontrato.getIdPreContrato();
        this.estado = precontrato.getEstado();
        this.descripcion = precontrato.getDescripcion();
        this.documento = precontrato.getDocumento();
        this.idDocumento = precontrato.getIdDocumento();
    }

    public String getIdPreContrato() {
        return idPreContrato;
    }

    public void setIdPreContrato(String idPreContrato) {
        this.idPreContrato = idPreContrato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(o instanceof MPrecontrato)) return false;
        MPrecontrato that = (MPrecontrato) o;
        return Objects.equals(getIdPreContrato(), that.getIdPreContrato()) &&
                Objects.equals(getEstado(), that.getEstado()) &&
                Objects.equals(getDescripcion(), that.getDescripcion()) &&
                Objects.equals(getDocumento(), that.getDocumento()) &&
                Objects.equals(getIdDocumento(), that.getIdDocumento());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdPreContrato(), getEstado(), getDescripcion(), getDocumento(), getIdDocumento());
    }

    @Override
    public String toString() {
        return "MPrecontrato{" +
                "idPreContrato='" + idPreContrato + '\'' +
                ", estado='" + estado + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", documento='" + documento + '\'' +
                ", idDocumento='" + idDocumento + '\'' +
                '}';
    }
}
