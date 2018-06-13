package com.api.apisigi.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO HISTVENTAS
@Entity
@Table(name = "HIST_VENTAS", schema = "SIGIADMIN", catalog = "")
public class HistVentas {
    private String idHistVenta;
    private long monto;
    private Time fechaVenta;
    private String vendedor;
    private String comprador;

    @Id
    @Column(name = "ID_HIST_VENTA")
    public String getIdHistVenta() {
        return idHistVenta;
    }

    public void setIdHistVenta(String idHistVenta) {
        this.idHistVenta = idHistVenta;
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
    @Column(name = "FECHA_VENTA")
    public Time getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Time fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Basic
    @Column(name = "VENDEDOR")
    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    @Basic
    @Column(name = "COMPRADOR")
    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistVentas that = (HistVentas) o;
        return monto == that.monto &&
                Objects.equals(idHistVenta, that.idHistVenta) &&
                Objects.equals(fechaVenta, that.fechaVenta) &&
                Objects.equals(vendedor, that.vendedor) &&
                Objects.equals(comprador, that.comprador);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idHistVenta, monto, fechaVenta, vendedor, comprador);
    }
}
