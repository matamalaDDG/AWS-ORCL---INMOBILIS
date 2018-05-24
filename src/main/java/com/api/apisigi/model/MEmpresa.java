package com.api.apisigi.model;

import com.api.apisigi.entity.Empresas;

import java.util.Objects;

public class MEmpresa {
    private String idEmpresa;
    private String nombreEmpresa;

    public MEmpresa() {
    }

    public MEmpresa(Empresas empresas) {
        this.idEmpresa = empresas.getIdEmpresa();
        this.nombreEmpresa = empresas.getNombreEmpresa();
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MEmpresa)) return false;
        MEmpresa mEmpresa = (MEmpresa) o;
        return Objects.equals(getIdEmpresa(), mEmpresa.getIdEmpresa()) &&
                Objects.equals(getNombreEmpresa(), mEmpresa.getNombreEmpresa());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdEmpresa(), getNombreEmpresa());
    }

    @Override
    public String toString() {
        return "MEmpresa{" +
                "idEmpresa='" + idEmpresa + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                '}';
    }
}
