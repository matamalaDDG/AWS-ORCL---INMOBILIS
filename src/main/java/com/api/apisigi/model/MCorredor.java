package com.api.apisigi.model;

import com.api.apisigi.entity.Corredor;

import java.util.Objects;

public class MCorredor {

    private String nombreCorredor;
    private String idCorredor;
    private String idPerfil;

    public MCorredor() {
    }

    public MCorredor(Corredor corredor) {
        this.nombreCorredor = corredor.getNombreCorredor();
        this.idCorredor = corredor.getIdCorredor();
        this.idPerfil = corredor.getIdPerfil();
    }

    public String getNombreCorredor() {
        return nombreCorredor;
    }

    public void setNombreCorredor(String nombreCorredor) {
        this.nombreCorredor = nombreCorredor;
    }

    public String getIdCorredor() {
        return idCorredor;
    }

    public void setIdCorredor(String idCorredor) {
        this.idCorredor = idCorredor;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MCorredor)) return false;
        MCorredor mCorredor = (MCorredor) o;
        return Objects.equals(getNombreCorredor(), mCorredor.getNombreCorredor()) &&
                Objects.equals(getIdCorredor(), mCorredor.getIdCorredor()) &&
                Objects.equals(getIdPerfil(), mCorredor.getIdPerfil());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNombreCorredor(), getIdCorredor(), getIdPerfil());
    }

    @Override
    public String toString() {
        return "MCorredor{" +
                "nombreCorredor='" + nombreCorredor + '\'' +
                ", idCorredor='" + idCorredor + '\'' +
                ", idPerfil='" + idPerfil + '\'' +
                '}';
    }
}
