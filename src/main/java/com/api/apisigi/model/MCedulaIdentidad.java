package com.api.apisigi.model;

import com.api.apisigi.entity.CedulaIdentidad;

import java.util.Objects;

public class MCedulaIdentidad {
    private String idCedula;
    private String descripcion;
    private String idDocumento;

    public MCedulaIdentidad() {
    }

    public MCedulaIdentidad(CedulaIdentidad cedulaidentidad) {
        this.idCedula = cedulaidentidad.getIdCedula();
        this.descripcion = cedulaidentidad.getDescripcion();
        this.idDocumento = cedulaidentidad.getIdDocumento();
    }

    public String getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(String idCedula) {
        this.idCedula = idCedula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MCedulaIdentidad)) return false;
        MCedulaIdentidad that = (MCedulaIdentidad) o;
        return Objects.equals(getIdCedula(), that.getIdCedula()) &&
                Objects.equals(getDescripcion(), that.getDescripcion()) &&
                Objects.equals(getIdDocumento(), that.getIdDocumento());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdCedula(), getDescripcion(), getIdDocumento());
    }

    @Override
    public String toString() {
        return "MCedulaIdentidad{" +
                "idCedula='" + idCedula + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", idDocumento='" + idDocumento + '\'' +
                '}';
    }
}
