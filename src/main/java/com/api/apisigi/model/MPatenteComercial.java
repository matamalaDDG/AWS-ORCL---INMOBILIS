package com.api.apisigi.model;

import com.api.apisigi.entity.PatenteComercial;

import java.util.Objects;

public class MPatenteComercial {

    private String idPatente;
    private String tipoPatente;

    public MPatenteComercial() {
    }

    public MPatenteComercial(PatenteComercial patentecomercial) {
        this.idPatente = patentecomercial.getIdPatente();
        this.tipoPatente = patentecomercial.getTipoPatente();
    }

    public String getIdPatente() {
        return idPatente;
    }

    public void setIdPatente(String idPatente) {
        this.idPatente = idPatente;
    }

    public String getTipoPatente() {
        return tipoPatente;
    }

    public void setTipoPatente(String tipoPatente) {
        this.tipoPatente = tipoPatente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MPatenteComercial)) return false;
        MPatenteComercial that = (MPatenteComercial) o;
        return Objects.equals(getIdPatente(), that.getIdPatente()) &&
                Objects.equals(getTipoPatente(), that.getTipoPatente());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdPatente(), getTipoPatente());
    }

    @Override
    public String toString() {
        return "MPatenteComercial{" +
                "idPatente='" + idPatente + '\'' +
                ", tipoPatente='" + tipoPatente + '\'' +
                '}';
    }


}
