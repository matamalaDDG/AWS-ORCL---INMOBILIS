package com.api.apisigi.model;

import com.api.apisigi.entity.Estacionamiento;

import java.util.Objects;

public class MEstacionamiento {
    private String idEstacionamiento;
    private String numEstacionamiento;
    private long nivelUbicacion;

    public MEstacionamiento() {
    }

    public MEstacionamiento(Estacionamiento estacionamiento) {
        this.idEstacionamiento = estacionamiento.getIdEstacionamiento();
        this.numEstacionamiento = estacionamiento.getNumEstacionamiento();
        this.nivelUbicacion = estacionamiento.getNivelUbicacion();
    }

    public String getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public void setIdEstacionamiento(String idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    public String getNumEstacionamiento() {
        return numEstacionamiento;
    }

    public void setNumEstacionamiento(String numEstacionamiento) {
        this.numEstacionamiento = numEstacionamiento;
    }

    public long getNivelUbicacion() {
        return nivelUbicacion;
    }

    public void setNivelUbicacion(long nivelUbicacion) {
        this.nivelUbicacion = nivelUbicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MEstacionamiento)) return false;
        MEstacionamiento that = (MEstacionamiento) o;
        return getNivelUbicacion() == that.getNivelUbicacion() &&
                Objects.equals(getIdEstacionamiento(), that.getIdEstacionamiento()) &&
                Objects.equals(getNumEstacionamiento(), that.getNumEstacionamiento());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdEstacionamiento(), getNumEstacionamiento(), getNivelUbicacion());
    }

    @Override
    public String toString() {
        return "MEstacionamiento{" +
                "idEstacionamiento='" + idEstacionamiento + '\'' +
                ", numEstacionamiento='" + numEstacionamiento + '\'' +
                ", nivelUbicacion=" + nivelUbicacion +
                '}';
    }
}
