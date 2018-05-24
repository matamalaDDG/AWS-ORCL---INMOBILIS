package com.api.apisigi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Venta {
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

    @Id
    @Column(name = "ID_VENTA")
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    @Basic
    @Column(name = "MONTO")
    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "FECHA_COMPRA")
    public Time getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Time fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Basic
    @Column(name = "ID_SERVICIO")
    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    @Basic
    @Column(name = "ID_CONVENIO")
    public String getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(String idConvenio) {
        this.idConvenio = idConvenio;
    }

    @Basic
    @Column(name = "ID_DOC_NOTARIA")
    public String getIdDocNotaria() {
        return idDocNotaria;
    }

    public void setIdDocNotaria(String idDocNotaria) {
        this.idDocNotaria = idDocNotaria;
    }

    @Basic
    @Column(name = "ID_DOC_CONSERVADOR")
    public String getIdDocConservador() {
        return idDocConservador;
    }

    public void setIdDocConservador(String idDocConservador) {
        this.idDocConservador = idDocConservador;
    }

    @Basic
    @Column(name = "ID_TASACION")
    public String getIdTasacion() {
        return idTasacion;
    }

    public void setIdTasacion(String idTasacion) {
        this.idTasacion = idTasacion;
    }

    @Basic
    @Column(name = "ID_BANCO")
    public String getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(String idBanco) {
        this.idBanco = idBanco;
    }

    @Basic
    @Column(name = "ID_CORREDOR")
    public String getIdCorredor() {
        return idCorredor;
    }

    public void setIdCorredor(String idCorredor) {
        this.idCorredor = idCorredor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return monto == venta.monto &&
                Objects.equals(idVenta, venta.idVenta) &&
                Objects.equals(fechaCompra, venta.fechaCompra) &&
                Objects.equals(idServicio, venta.idServicio) &&
                Objects.equals(idConvenio, venta.idConvenio) &&
                Objects.equals(idDocNotaria, venta.idDocNotaria) &&
                Objects.equals(idDocConservador, venta.idDocConservador) &&
                Objects.equals(idTasacion, venta.idTasacion) &&
                Objects.equals(idBanco, venta.idBanco) &&
                Objects.equals(idCorredor, venta.idCorredor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idVenta, monto, fechaCompra, idServicio, idConvenio, idDocNotaria, idDocConservador, idTasacion, idBanco, idCorredor);
    }
}
