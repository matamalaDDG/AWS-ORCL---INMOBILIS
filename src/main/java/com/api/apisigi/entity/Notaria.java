package com.api.apisigi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Notaria {
    private String idNotaria;
    private String descripcion;
    private String idDocNotaria;

    @Id
    @Column(name = "ID_NOTARIA")
    public String getIdNotaria() {
        return idNotaria;
    }

    public void setIdNotaria(String idNotaria) {
        this.idNotaria = idNotaria;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ID_DOC_NOTARIA")
    public String getIdDocNotaria() {
        return idDocNotaria;
    }

    public void setIdDocNotaria(String idDocNotaria) {
        this.idDocNotaria = idDocNotaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notaria notaria = (Notaria) o;
        return Objects.equals(idNotaria, notaria.idNotaria) &&
                Objects.equals(descripcion, notaria.descripcion) &&
                Objects.equals(idDocNotaria, notaria.idDocNotaria);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idNotaria, descripcion, idDocNotaria);
    }
}
