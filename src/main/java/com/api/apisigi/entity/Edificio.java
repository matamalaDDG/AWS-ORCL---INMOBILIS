package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Edificio {
    private String idEdificio;
    private String nombreEdi;
    private String numeroEdificio;
    private Collection<Departamento> departamentosByIdEdificio;

    @Id
    @Column(name = "ID_EDIFICIO")
    public String getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(String idEdificio) {
        this.idEdificio = idEdificio;
    }

    @Basic
    @Column(name = "NOMBRE_EDI")
    public String getNombreEdi() {
        return nombreEdi;
    }

    public void setNombreEdi(String nombreEdi) {
        this.nombreEdi = nombreEdi;
    }

    @Basic
    @Column(name = "NUMERO_EDIFICIO")
    public String getNumeroEdificio() {
        return numeroEdificio;
    }

    public void setNumeroEdificio(String numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edificio edificio = (Edificio) o;
        return Objects.equals(idEdificio, edificio.idEdificio) &&
                Objects.equals(nombreEdi, edificio.nombreEdi) &&
                Objects.equals(numeroEdificio, edificio.numeroEdificio);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idEdificio, nombreEdi, numeroEdificio);
    }

    @OneToMany(mappedBy = "edificioByIdEdificio")
    public Collection<Departamento> getDepartamentosByIdEdificio() {
        return departamentosByIdEdificio;
    }

    public void setDepartamentosByIdEdificio(Collection<Departamento> departamentosByIdEdificio) {
        this.departamentosByIdEdificio = departamentosByIdEdificio;
    }
}
