package com.api.apisigi.model;

import com.api.apisigi.entity.HistVentas;

import java.sql.Time;
import java.util.Objects;

public class MHistVentas {

    private String idHistVenta;
    private long monto;
    private Time fechaVenta;
    private String vendedor;
    private String comprador;

    public MHistVentas() {
    }

    public MHistVentas(HistVentas histventas) {
        this.idHistVenta = histventas.getIdHistVenta();
        this.monto = histventas.getMonto();
        this.fechaVenta = histventas.getFechaVenta();
        this.vendedor = histventas.getVendedor();
        this.comprador = histventas.getComprador();
    }

    public String getIdHistVenta() {
        return idHistVenta;
    }

    public void setIdHistVenta(String idHistVenta) {
        this.idHistVenta = idHistVenta;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public Time getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Time fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MHistVentas)) return false;
        MHistVentas that = (MHistVentas) o;
        return getMonto() == that.getMonto() &&
                Objects.equals(getIdHistVenta(), that.getIdHistVenta()) &&
                Objects.equals(getFechaVenta(), that.getFechaVenta()) &&
                Objects.equals(getVendedor(), that.getVendedor()) &&
                Objects.equals(getComprador(), that.getComprador());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdHistVenta(), getMonto(), getFechaVenta(), getVendedor(), getComprador());
    }

    @Override
    public String toString() {
        return "MHistVentas{" +
                "idHistVenta='" + idHistVenta + '\'' +
                ", monto=" + monto +
                ", fechaVenta=" + fechaVenta +
                ", vendedor='" + vendedor + '\'' +
                ", comprador='" + comprador + '\'' +
                '}';
    }
}
