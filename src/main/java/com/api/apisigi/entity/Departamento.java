package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Departamento {
    private String idDepto;
    private String idEdificio;
    private long cantDorm;
    private long numDepto;
    private long cantBaños;
    private long mtsCuadConst;
    private Edificio edificioByIdEdificio;
    private Collection<Propiedad> propiedadsByIdDepto;

    @Id
    @Column(name = "ID_DEPTO")
    public String getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(String idDepto) {
        this.idDepto = idDepto;
    }

    @Basic
    @Column(name = "ID_EDIFICIO")
    public String getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(String idEdificio) {
        this.idEdificio = idEdificio;
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
                Objects.equals(idDepto, that.idDepto) &&
                Objects.equals(idEdificio, that.idEdificio);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDepto, idEdificio, cantDorm, numDepto, cantBaños, mtsCuadConst);
    }

    @ManyToOne
    @JoinColumn(name = "ID_EDIFICIO", referencedColumnName = "ID_EDIFICIO", nullable = false)
    public Edificio getEdificioByIdEdificio() {
        return edificioByIdEdificio;
    }

    public void setEdificioByIdEdificio(Edificio edificioByIdEdificio) {
        this.edificioByIdEdificio = edificioByIdEdificio;
    }

    @OneToMany(mappedBy = "departamentoByIdDepto")
    public Collection<Propiedad> getPropiedadsByIdDepto() {
        return propiedadsByIdDepto;
    }

    public void setPropiedadsByIdDepto(Collection<Propiedad> propiedadsByIdDepto) {
        this.propiedadsByIdDepto = propiedadsByIdDepto;
    }
}
