package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Bodega {
    private String idBodega;
    private long numIdentBodega;
    private long mtsCuad;
    private Propiedad propiedad;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bodega bodega = (Bodega) o;
        return numIdentBodega == bodega.numIdentBodega &&
                mtsCuad == bodega.mtsCuad &&
                Objects.equals(idBodega, bodega.idBodega);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBodega, numIdentBodega, mtsCuad);
    }

    @ManyToOne
    @JoinColumn(name = "ID_PROPIEDAD", referencedColumnName = "ID_PROPIEDAD")
    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }
}
