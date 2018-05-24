package com.api.apisigi.model;

import com.api.apisigi.entity.Tasacion;

import java.util.Objects;

public class MTasacion {

    private String idTasacion;
    private long monto;
    private String nomTasador;
    private String descripcion;
    private String documento;
    private String idDocumento;

    public MTasacion() {
    }

    public MTasacion(Tasacion tasacion) {
        this.idTasacion = tasacion.getIdTasacion();
        this.monto = tasacion.getMonto();
        this.nomTasador = tasacion.getNomTasador();
        this.descripcion = tasacion.getDescripcion();
        this.documento = tasacion.getDocumento();
        this.idDocumento = tasacion.getIdDocumento();
    }

    public String getIdTasacion() {

        return idTasacion;
    }

    public void setIdTasacion(String idTasacion) {
        this.idTasacion = idTasacion;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getNomTasador() {
        return nomTasador;
    }

    public void setNomTasador(String nomTasador) {
        this.nomTasador = nomTasador;
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
        if (!(o instanceof MTasacion)) return false;
        MTasacion mTasacion = (MTasacion) o;
        return getMonto() == mTasacion.getMonto() &&
                Objects.equals(getIdTasacion(), mTasacion.getIdTasacion()) &&
                Objects.equals(getNomTasador(), mTasacion.getNomTasador()) &&
                Objects.equals(getDescripcion(), mTasacion.getDescripcion()) &&
                Objects.equals(getDocumento(), mTasacion.getDocumento()) &&
                Objects.equals(getIdDocumento(), mTasacion.getIdDocumento());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdTasacion(), getMonto(), getNomTasador(), getDescripcion(), getDocumento(), getIdDocumento());
    }

    @Override
    public String toString() {
        return "MTasacion{" +
                "idTasacion='" + idTasacion + '\'' +
                ", monto=" + monto +
                ", nomTasador='" + nomTasador + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", documento='" + documento + '\'' +
                ", idDocumento='" + idDocumento + '\'' +
                '}';
    }
}
