package com.api.apisigi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Bodega {
    private String idBodega;
    private long numIdentBodega;
    private long mtsCuad;
    private String idPropiedad;

    @Id
    @Column(name = "ID_BODEGA")
    public String getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(String idBodega) {
        this.idBodega = idBodega;
    }

    @Basic
    @Column(name = "NUM_IDENT_BODEGA")
    public long getNumIdentBodega() {
        return numIdentBodega;
    }

    public void setNumIdentBodega(long numIdentBodega) {
        this.numIdentBodega = numIdentBodega;
    }

    @Basic
    @Column(name = "MTS_CUAD")
    public long getMtsCuad() {
        return mtsCuad;
    }

    public void setMtsCuad(long mtsCuad) {
        this.mtsCuad = mtsCuad;
    }

    @Basic
    @Column(name = "ID_PROPIEDAD")
    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bodega bodega = (Bodega) o;
        return numIdentBodega == bodega.numIdentBodega &&
                mtsCuad == bodega.mtsCuad &&
                Objects.equals(idBodega, bodega.idBodega) &&
                Objects.equals(idPropiedad, bodega.idPropiedad);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBodega, numIdentBodega, mtsCuad, idPropiedad);
    }
}
