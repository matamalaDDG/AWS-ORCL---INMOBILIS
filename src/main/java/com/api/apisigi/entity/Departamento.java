package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class Departamento {
    private String idDepto;
    private long cantDorm;
    private long numDepto;
    private long cantBaños;
    private long mtsCuadConst;
    private Edificio edificio;
    private List<Propiedad> propiedad;

    @Id
    @Column(name = "ID_DEPTO")
    public String getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(String idDepto) {
        this.idDepto = idDepto;
    }

    @Basic
    @Column(name = "CANT_DORM")
    public long getCantDorm() {
        return cantDorm;
    }

    public void setCantDorm(long cantDorm) {
        this.cantDorm = cantDorm;
    }

    @Basic
    @Column(name = "NUM_DEPTO")
    public long getNumDepto() {
        return numDepto;
    }

    public void setNumDepto(long numDepto) {
        this.numDepto = numDepto;
    }

    @Basic
    @Column(name = "CANT_BAÑOS")
    public long getCantBaños() {
        return cantBaños;
    }

    public void setCantBaños(long cantBaños) {
        this.cantBaños = cantBaños;
    }

    @Basic
    @Column(name = "MTS_CUAD_CONST")
    public long getMtsCuadConst() {
        return mtsCuadConst;
    }

    public void setMtsCuadConst(long mtsCuadConst) {
        this.mtsCuadConst = mtsCuadConst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return cantDorm == that.cantDorm &&
                numDepto == that.numDepto &&
                cantBaños == that.cantBaños &&
                mtsCuadConst == that.mtsCuadConst &&
                Objects.equals(idDepto, that.idDepto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDepto, cantDorm, numDepto, cantBaños, mtsCuadConst);
    }

    @ManyToOne
    @JoinColumn(name = "ID_EDIFICIO", referencedColumnName = "ID_EDIFICIO", nullable = false)
    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @OneToMany(mappedBy = "departamento")
    public List<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(List<Propiedad> propiedad) {
        this.propiedad = propiedad;
    }
}
