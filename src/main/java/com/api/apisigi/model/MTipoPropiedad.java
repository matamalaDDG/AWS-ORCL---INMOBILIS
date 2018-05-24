package com.api.apisigi.model;

import com.api.apisigi.entity.TipoPropiedad;

import java.util.Objects;

public class MTipoPropiedad {
    private String idTipoProp;
    private String descripcion;

    public MTipoPropiedad() {
    }

    public MTipoPropiedad(TipoPropiedad tipoPropiedad) {
        this.idTipoProp = tipoPropiedad.getIdTipoProp();
        this.descripcion = tipoPropiedad.getDescripcion();
    }

    public String getIdTipoProp() {
        return idTipoProp;
    }

    public void setIdTipoProp(String idTipoProp) {
        this.idTipoProp = idTipoProp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MTipoPropiedad)) return false;
        MTipoPropiedad that = (MTipoPropiedad) o;
        return Objects.equals(getIdTipoProp(), that.getIdTipoProp()) &&
                Objects.equals(getDescripcion(), that.getDescripcion());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdTipoProp(), getDescripcion());
    }

    @Override
    public String toString() {
        return "MTipoPropiedad{" +
                "idTipoProp='" + idTipoProp + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }


}
