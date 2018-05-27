package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Estado {
    private String idEstado;
    private String estado;
    private Collection<Propiedad> propiedadsByIdEstado;

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

    @OneToMany(mappedBy = "estadoByIdEstado")
    public Collection<Propiedad> getPropiedadsByIdEstado() {
        return propiedadsByIdEstado;
    }

    public void setPropiedadsByIdEstado(Collection<Propiedad> propiedadsByIdEstado) {
        this.propiedadsByIdEstado = propiedadsByIdEstado;
    }
}
