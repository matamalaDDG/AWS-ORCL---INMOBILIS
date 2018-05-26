package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Oficina {
    private String idOficina;
    private long numOficina;
    private long mtsCuadDisp;
    private String idPatente;
    private PatenteComercial patenteComercialByIdPatente;
    private Collection<Propiedad> propiedadsByIdOficina;

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

    @Basic
    @Column(name = "ID_PATENTE")
    public String getIdPatente() {
        return idPatente;
    }

    public void setIdPatente(String idPatente) {
        this.idPatente = idPatente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oficina oficina = (Oficina) o;
        return numOficina == oficina.numOficina &&
                mtsCuadDisp == oficina.mtsCuadDisp &&
                Objects.equals(idOficina, oficina.idOficina) &&
                Objects.equals(idPatente, oficina.idPatente);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idOficina, numOficina, mtsCuadDisp, idPatente);
    }

    @ManyToOne
    @JoinColumn(name = "ID_PATENTE", referencedColumnName = "ID_PATENTE")
    public PatenteComercial getPatenteComercialByIdPatente() {
        return patenteComercialByIdPatente;
    }

    public void setPatenteComercialByIdPatente(PatenteComercial patenteComercialByIdPatente) {
        this.patenteComercialByIdPatente = patenteComercialByIdPatente;
    }

    @OneToMany(mappedBy = "oficinaByIdOficina")
    public Collection<Propiedad> getPropiedadsByIdOficina() {
        return propiedadsByIdOficina;
    }

    public void setPropiedadsByIdOficina(Collection<Propiedad> propiedadsByIdOficina) {
        this.propiedadsByIdOficina = propiedadsByIdOficina;
    }
}
