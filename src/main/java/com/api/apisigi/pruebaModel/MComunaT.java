package com.api.apisigi.pruebaModel;

import com.api.apisigi.pruebaEntity.Comuna;
import com.api.apisigi.pruebaEntity.Region;

import java.util.Objects;

public class MComunaT {

    private String idComuna;
    private String comuna;
    private Region regionByIdRegion;

    public MComunaT() {
    }

    public MComunaT(Comuna comuna) {
        this.idComuna = comuna.getIdComuna();
        this.comuna = comuna.getComuna();
        this.regionByIdRegion = comuna.getRegionByIdRegion();
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

    public Region getRegionByIdRegion() {
        return regionByIdRegion;
    }

    public void setRegionByIdRegion(Region regionByIdRegion) {
        this.regionByIdRegion = regionByIdRegion;
    }

    @Override
    public String toString() {
        return "MComunaT{" +
                "idComuna='" + idComuna + '\'' +
                ", comuna='" + comuna + '\'' +
                ", regionByIdRegion=" + regionByIdRegion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MComunaT)) return false;
        MComunaT mComunaT = (MComunaT) o;
        return Objects.equals(getIdComuna(), mComunaT.getIdComuna()) &&
                Objects.equals(getComuna(), mComunaT.getComuna()) &&
                Objects.equals(getRegionByIdRegion(), mComunaT.getRegionByIdRegion());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdComuna(), getComuna(), getRegionByIdRegion());
    }
}
