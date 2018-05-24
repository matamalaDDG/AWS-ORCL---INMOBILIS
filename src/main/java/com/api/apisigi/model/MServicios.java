package com.api.apisigi.model;

import com.api.apisigi.entity.Servicios;

import java.util.Objects;

public class MServicios {

    private String idServicio;
    private String servicio;
    private long valorServicio;

    public MServicios() {
    }

    public MServicios(Servicios servicios) {
        this.idServicio = servicios.getIdServicio();
        this.servicio = servicios.getServicio();
        this.valorServicio = servicios.getValorServicio();
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public long getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(long valorServicio) {
        this.valorServicio = valorServicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MServicios)) return false;
        MServicios that = (MServicios) o;
        return getValorServicio() == that.getValorServicio() &&
                Objects.equals(getIdServicio(), that.getIdServicio()) &&
                Objects.equals(getServicio(), that.getServicio());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdServicio(), getServicio(), getValorServicio());
    }

    @Override
    public String toString() {
        return "MServicios{" +
                "idServicio='" + idServicio + '\'' +
                ", servicio='" + servicio + '\'' +
                ", valorServicio=" + valorServicio +
                '}';
    }
}
