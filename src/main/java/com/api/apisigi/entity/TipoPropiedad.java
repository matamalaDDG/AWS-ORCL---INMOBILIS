package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO TIPOPROPIEDAD
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class TipoPropiedad {
    private String idTipoProp;
    private String descripcion;
    private List<Propiedad> propiedad;

    @Id
    @Column(name = "ID_TIPO_PROP")
    public String getIdTipoProp() {
        return idTipoProp;
    }

    public void setIdTipoProp(String idTipoProp) {
        this.idTipoProp = idTipoProp;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoPropiedad that = (TipoPropiedad) o;
        return Objects.equals(idTipoProp, that.idTipoProp) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTipoProp, descripcion);
    }

    @OneToMany(mappedBy = "tipopropiedad")
    public List<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(List<Propiedad> propiedad) {
        this.propiedad = propiedad;
    }
}
