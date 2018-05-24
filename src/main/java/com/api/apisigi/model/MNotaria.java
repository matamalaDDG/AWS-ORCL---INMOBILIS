package com.api.apisigi.model;

import com.api.apisigi.entity.Notaria;

import java.util.Objects;

public class MNotaria {

    private String idNotaria;
    private String descripcion;
    private String idDocNotaria;

    public MNotaria() {
    }

    public MNotaria(Notaria notaria) {
        this.idNotaria = notaria.getIdNotaria();
        this.descripcion = notaria.getDescripcion();
        this.idDocNotaria = notaria.getIdDocNotaria();
    }

    public String getIdNotaria() {
        return idNotaria;
    }

    public void setIdNotaria(String idNotaria) {
        this.idNotaria = idNotaria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdDocNotaria() {
        return idDocNotaria;
    }

    public void setIdDocNotaria(String idDocNotaria) {
        this.idDocNotaria = idDocNotaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MNotaria)) return false;
        MNotaria mNotaria = (MNotaria) o;
        return Objects.equals(getIdNotaria(), mNotaria.getIdNotaria()) &&
                Objects.equals(getDescripcion(), mNotaria.getDescripcion()) &&
                Objects.equals(getIdDocNotaria(), mNotaria.getIdDocNotaria());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdNotaria(), getDescripcion(), getIdDocNotaria());
    }

    @Override
    public String toString() {
        return "MNotaria{" +
                "idNotaria='" + idNotaria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", idDocNotaria='" + idDocNotaria + '\'' +
                '}';
    }
}
