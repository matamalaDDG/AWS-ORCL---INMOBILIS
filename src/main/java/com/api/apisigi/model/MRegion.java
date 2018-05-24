package com.api.apisigi.model;

import com.api.apisigi.entity.Region;

import java.util.Objects;

public class MRegion {

    private String idRegion;
    private String region;

    public MRegion() {
    }

    public MRegion(Region region) {
        this.idRegion = region.getIdRegion();
        this.region = region.getRegion();
    }

    public String getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof MRegion)) return false;
        MRegion mRegion = (MRegion) o;
        return Objects.equals(getIdRegion(), mRegion.getIdRegion()) &&
                Objects.equals(getRegion(), mRegion.getRegion());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdRegion(), getRegion());
    }

    @Override
    public String toString() {
        return "MRegion{" +
                "idRegion='" + idRegion + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
