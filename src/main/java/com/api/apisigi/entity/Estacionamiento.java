package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO ESTACIONAMIENTO
@Entity
public class Estacionamiento {
    private String idEstacionamiento;
    private String numEstacionamiento;
    private long nivelUbicacion;
    private Collection<Propiedad> propiedad;

    @Id
    @Column(name = "ID_ESTACIONAMIENTO")
    public String getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public void setIdEstacionamiento(String idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    @Basic
    @Column(name = "NUM_ESTACIONAMIENTO")
    public String getNumEstacionamiento() {
        return numEstacionamiento;
    }

    public void setNumEstacionamiento(String numEstacionamiento) {
        this.numEstacionamiento = numEstacionamiento;
    }

    @Basic
    @Column(name = "NIVEL_UBICACION")
    public long getNivelUbicacion() {
        return nivelUbicacion;
    }

    public void setNivelUbicacion(long nivelUbicacion) {
        this.nivelUbicacion = nivelUbicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estacionamiento that = (Estacionamiento) o;
        return nivelUbicacion == that.nivelUbicacion &&
                Objects.equals(idEstacionamiento, that.idEstacionamiento) &&
                Objects.equals(numEstacionamiento, that.numEstacionamiento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idEstacionamiento, numEstacionamiento, nivelUbicacion);
    }

    @OneToMany(mappedBy = "estacionamiento")
    public Collection<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Collection<Propiedad> propiedad) {
        this.propiedad = propiedad;
    }
}
