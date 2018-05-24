package com.api.apisigi.model;

import com.api.apisigi.entity.Comuna;

import java.util.Objects;

public class MComuna {
    private String idComuna;
    private String comuna;
    private String idRegion;

    public MComuna() {
    }

    public MComuna(Comuna comuna) {
        this.idComuna = comuna.getIdComuna();
        this.comuna = comuna.getComuna();
        this.idRegion = comuna.getIdRegion();
    }

    public String getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(String idComuna) {
        this.idComuna = idComuna;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MComuna)) return false;
        MComuna mComuna = (MComuna) o;
        return Objects.equals(getIdComuna(), mComuna.getIdComuna()) &&
                Objects.equals(getComuna(), mComuna.getComuna()) &&
                Objects.equals(getIdRegion(), mComuna.getIdRegion());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdComuna(), getComuna(), getIdRegion());
    }

    @Override
    public String toString() {
        return "MComuna{" +
                "idComuna='" + idComuna + '\'' +
                ", comuna='" + comuna + '\'' +
                ", idRegion='" + idRegion + '\'' +
                '}';
    }
}
