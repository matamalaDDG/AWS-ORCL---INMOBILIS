package com.api.apisigi.model;

import com.api.apisigi.entity.Aseguradora;

import java.util.Objects;

public class MAseguradora {

    private String idAseguradora;
    private String tipoSeguro;
    private String aseguradora;

    public MAseguradora() {
    }

    public MAseguradora(Aseguradora aseguradora) {
        this.idAseguradora = aseguradora.getIdAseguradora();
        this.tipoSeguro = aseguradora.getTipoSeguro();
        this.aseguradora = aseguradora.getAseguradora();
    }

    public String getIdAseguradora() {
        return idAseguradora;
    }

    public void setIdAseguradora(String idAseguradora) {
        this.idAseguradora = idAseguradora;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MAseguradora)) return false;
        MAseguradora that = (MAseguradora) o;
        return Objects.equals(getIdAseguradora(), that.getIdAseguradora()) &&
                Objects.equals(getTipoSeguro(), that.getTipoSeguro()) &&
                Objects.equals(getAseguradora(), that.getAseguradora());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdAseguradora(), getTipoSeguro(), getAseguradora());
    }

    @Override
    public String toString() {
        return "MAseguradora{" +
                "idAseguradora='" + idAseguradora + '\'' +
                ", tipoSeguro='" + tipoSeguro + '\'' +
                ", aseguradora='" + aseguradora + '\'' +
                '}';
    }
}


