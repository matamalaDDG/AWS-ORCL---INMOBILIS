package com.api.apisigi.model;

import com.api.apisigi.entity.Bodega;

import java.util.Objects;

public class MBodega {
    private String idBodega;
    private long numIdentBodega;
    private long mtsCuad;
    private String idPropiedad;

    public MBodega() {
    }

    public MBodega(Bodega bodega) {
        this.idBodega = bodega.getIdBodega();
        this.numIdentBodega = bodega.getNumIdentBodega();
        this.mtsCuad = bodega.getMtsCuad();
        this.idPropiedad = bodega.getIdPropiedad();
    }

    public String getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(String idBodega) {
        this.idBodega = idBodega;
    }

    public long getNumIdentBodega() {
        return numIdentBodega;
    }

    public void setNumIdentBodega(long numIdentBodega) {
        this.numIdentBodega = numIdentBodega;
    }

    public long getMtsCuad() {
        return mtsCuad;
    }

    public void setMtsCuad(long mtsCuad) {
        this.mtsCuad = mtsCuad;
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MBodega)) return false;
        MBodega mBodega = (MBodega) o;
        return getNumIdentBodega() == mBodega.getNumIdentBodega() &&
                getMtsCuad() == mBodega.getMtsCuad() &&
                Objects.equals(getIdBodega(), mBodega.getIdBodega()) &&
                Objects.equals(getIdPropiedad(), mBodega.getIdPropiedad());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdBodega(), getNumIdentBodega(), getMtsCuad(), getIdPropiedad());
    }


}
