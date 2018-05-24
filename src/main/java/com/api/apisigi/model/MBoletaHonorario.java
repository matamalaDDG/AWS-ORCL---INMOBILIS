package com.api.apisigi.model;

import com.api.apisigi.entity.BoletaHonorario;

import java.util.Objects;

public class MBoletaHonorario {
    private String idBoleta;
    private String descripcion;
    private String idDocumento;


    public MBoletaHonorario() {
    }

    public MBoletaHonorario(BoletaHonorario boletahonorario) {
        this.idBoleta = boletahonorario.getIdBoleta();
        this.descripcion = boletahonorario.getDescripcion();
        this.idDocumento = boletahonorario.getIdDocumento();
    }

    public String getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(String idBoleta) {
        this.idBoleta = idBoleta;
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
        if (!(o instanceof MBoletaHonorario)) return false;
        MBoletaHonorario that = (MBoletaHonorario) o;
        return Objects.equals(getIdBoleta(), that.getIdBoleta()) &&
                Objects.equals(getDescripcion(), that.getDescripcion()) &&
                Objects.equals(getIdDocumento(), that.getIdDocumento());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdBoleta(), getDescripcion(), getIdDocumento());
    }

    @Override
    public String toString() {
        return "MBoletaHonorario{" +
                "idBoleta='" + idBoleta + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", idDocumento='" + idDocumento + '\'' +
                '}';
    }
}
