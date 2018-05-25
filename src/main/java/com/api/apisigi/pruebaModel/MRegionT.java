package com.api.apisigi.pruebaModel;

import com.api.apisigi.pruebaEntity.Region;

import java.util.Objects;

public class MRegionT {

    private String idRegion;
    private String region;

    public MRegionT() {
    }

    public MRegionT(Region region) {
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
    public String toString() {
        return "MRegionT{" +
                "idRegion='" + idRegion + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MRegionT)) return false;
        MRegionT mRegionT = (MRegionT) o;
        return Objects.equals(getIdRegion(), mRegionT.getIdRegion()) &&
                Objects.equals(getRegion(), mRegionT.getRegion());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdRegion(), getRegion());
    }
}
