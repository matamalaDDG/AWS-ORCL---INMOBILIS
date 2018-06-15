package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO OFICINA
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class Oficina {
    private String idOficina;
    private long numOficina;
    private long mtsCuadDisp;
    private PatenteComercial patenteComercial;
    private Collection<com.api.apisigi.entity.Propiedad> Propiedad;

    @Id
    @Column(name = "ID_OFICINA")
    public String getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(String idOficina) {
        this.idOficina = idOficina;
    }

    @Basic
    @Column(name = "NUM_OFICINA")
    public long getNumOficina() {
        return numOficina;
    }

    public void setNumOficina(long numOficina) {
        this.numOficina = numOficina;
    }

    @Basic
    @Column(name = "MTS_CUAD_DISP")
    public long getMtsCuadDisp() {
        return mtsCuadDisp;
    }

    public void setMtsCuadDisp(long mtsCuadDisp) {
        this.mtsCuadDisp = mtsCuadDisp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oficina oficina = (Oficina) o;
        return numOficina == oficina.numOficina &&
                mtsCuadDisp == oficina.mtsCuadDisp &&
                Objects.equals(idOficina, oficina.idOficina);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idOficina, numOficina, mtsCuadDisp);
    }

    @ManyToOne
    @JoinColumn(name = "ID_PATENTE", referencedColumnName = "ID_PATENTE")
    public PatenteComercial getPatenteComercial() {
        return patenteComercial;
    }

    public void setPatenteComercial(PatenteComercial patenteComercial) {
        this.patenteComercial = patenteComercial;
    }

    @OneToMany(mappedBy = "oficina")
    public Collection<com.api.apisigi.entity.Propiedad> getPropiedad() {
        return Propiedad;
    }

    public void setPropiedad(Collection<com.api.apisigi.entity.Propiedad> propiedad) {
        Propiedad = propiedad;
    }
}
