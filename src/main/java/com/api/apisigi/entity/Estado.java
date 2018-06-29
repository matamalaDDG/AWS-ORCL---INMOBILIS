package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO ESTADO
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class Estado {
    private String idEstado;
    private String estado;
    @JsonBackReference
    private List<Propiedad> propiedad;

    @Id
    @Column(name = "ID_ESTADO")
    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado1 = (Estado) o;
        return Objects.equals(idEstado, estado1.idEstado) &&
                Objects.equals(estado, estado1.estado);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idEstado, estado);
    }

    @OneToMany(mappedBy = "estado")
    public List<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(List<Propiedad> propiedad) {
        this.propiedad = propiedad;
    }
}
