package com.api.apisigi.model;

import com.api.apisigi.entity.Venta;

import java.sql.Time;
import java.util.Objects;

public class MVenta {


    private String idVenta;
    private long monto;
    private Time fechaCompra;
    private String idServicio;
    private String idConvenio;
    private String idDocNotaria;
    private String idDocConservador;
    private String idTasacion;
    private String idBanco;
    private String idCorredor;

    public MVenta() {
    }

    public MVenta(Venta venta) {
        this.idVenta = venta.getIdVenta();
        this.monto = venta.getMonto();
        this.fechaCompra = venta.getFechaCompra();
        this.idServicio = venta.getIdServicio();
        this.idConvenio = venta.getIdConvenio();
        this.idDocNotaria = venta.getIdDocNotaria();
        this.idDocConservador = venta.getIdDocConservador();
        this.idTasacion = venta.getIdTasacion();
        this.idBanco = venta.getIdBanco();
        this.idCorredor = venta.getIdCorredor();
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public Time getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Time fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(String idConvenio) {
        this.idConvenio = idConvenio;
    }

    public String getIdDocNotaria() {
        return idDocNotaria;
    }

    public void setIdDocNotaria(String idDocNotaria) {
        this.idDocNotaria = idDocNotaria;
    }

    public String getIdDocConservador() {
        return idDocConservador;
    }

    public void setIdDocConservador(String idDocConservador) {
        this.idDocConservador = idDocConservador;
    }

    public String getIdTasacion() {
        return idTasacion;
    }

    public void setIdTasacion(String idTasacion) {
        this.idTasacion = idTasacion;
    }

    public String getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(String idBanco) {
        this.idBanco = idBanco;
    }

    public String getIdCorredor() {
        return idCorredor;
    }

    public void setIdCorredor(String idCorredor) {
        this.idCorredor = idCorredor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MVenta)) return false;
        MVenta mVenta = (MVenta) o;
        return getMonto() == mVenta.getMonto() &&
                Objects.equals(getIdVenta(), mVenta.getIdVenta()) &&
                Objects.equals(getFechaCompra(), mVenta.getFechaCompra()) &&
                Objects.equals(getIdServicio(), mVenta.getIdServicio()) &&
                Objects.equals(getIdConvenio(), mVenta.getIdConvenio()) &&
                Objects.equals(getIdDocNotaria(), mVenta.getIdDocNotaria()) &&
                Objects.equals(getIdDocConservador(), mVenta.getIdDocConservador()) &&
                Objects.equals(getIdTasacion(), mVenta.getIdTasacion()) &&
                Objects.equals(getIdBanco(), mVenta.getIdBanco()) &&
                Objects.equals(getIdCorredor(), mVenta.getIdCorredor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdVenta(), getMonto(), getFechaCompra(), getIdServicio(), getIdConvenio(), getIdDocNotaria(), getIdDocConservador(), getIdTasacion(), getIdBanco(), getIdCorredor());
    }

    @Override
    public String toString() {
        return "MVenta{" +
                "idVenta='" + idVenta + '\'' +
                ", monto=" + monto +
                ", fechaCompra=" + fechaCompra +
                ", idServicio='" + idServicio + '\'' +
                ", idConvenio='" + idConvenio + '\'' +
                ", idDocNotaria='" + idDocNotaria + '\'' +
                ", idDocConservador='" + idDocConservador + '\'' +
                ", idTasacion='" + idTasacion + '\'' +
                ", idBanco='" + idBanco + '\'' +
                ", idCorredor='" + idCorredor + '\'' +
                '}';
    }
}
