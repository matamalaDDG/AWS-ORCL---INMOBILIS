package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO  BODEGA
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class Bodega {
    private String idBodega;
    private long numIdentBodega;
    private long mtsCuad;
    private List<Propiedad> propiedad;

    @Id
    @Column(name = "IDBODEGA")
    public String getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(String idBodega) {
        this.idBodega = idBodega;
    }

    @Basic
    @Column(name = "NUMIDENTBODEGA")
    public long getNumIdentBodega() {
        return numIdentBodega;
    }

    public void setNumIdentBodega(long numIdentBodega) {
        this.numIdentBodega = numIdentBodega;
    }

    @Basic
    @Column(name = "MTSCUAD")
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

    @JsonIgnore
    @OneToMany(mappedBy = "bodega",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    public List<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(List<Propiedad> propiedad) {
        this.propiedad = propiedad;
    }
}
