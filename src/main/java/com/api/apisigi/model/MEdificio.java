package com.api.apisigi.model;

import com.api.apisigi.entity.Edificio;

import java.util.Objects;

public class MEdificio {

    private String idEdificio;
    private String nombreEdi;
    private String numeroEdificio;

    public MEdificio() {
    }

    public MEdificio(Edificio edificio) {
        this.idEdificio = edificio.getIdEdificio();
        this.nombreEdi = edificio.getNombreEdi();
        this.numeroEdificio = edificio.getNumeroEdificio();
    }

    public String getIdEdificio() {

        return idEdificio;
    }

    public void setIdEdificio(String idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getNombreEdi() {
        return nombreEdi;
    }

    public void setNombreEdi(String nombreEdi) {
        this.nombreEdi = nombreEdi;
    }

    public String getNumeroEdificio() {
        return numeroEdificio;
    }

    public void setNumeroEdificio(String numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MEdificio)) return false;
        MEdificio mEdificio = (MEdificio) o;
        return Objects.equals(getIdEdificio(), mEdificio.getIdEdificio()) &&
                Objects.equals(getNombreEdi(), mEdificio.getNombreEdi()) &&
                Objects.equals(getNumeroEdificio(), mEdificio.getNumeroEdificio());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdEdificio(), getNombreEdi(), getNumeroEdificio());
    }

    @Override
    public String toString() {
        return "MEdificio{" +
                "idEdificio='" + idEdificio + '\'' +
                ", nombreEdi='" + nombreEdi + '\'' +
                ", numeroEdificio='" + numeroEdificio + '\'' +
                '}';
    }
}
