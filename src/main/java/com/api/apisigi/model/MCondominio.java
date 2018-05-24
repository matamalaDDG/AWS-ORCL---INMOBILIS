package com.api.apisigi.model;

import com.api.apisigi.entity.Condominio;

import java.util.Objects;

public class MCondominio {

    private String idCondominio;
    private String nombre;
    private long numeroCond;

    public MCondominio() {

    }

    public MCondominio(Condominio condominio) {
        this.idCondominio = condominio.getIdCondominio();
        this.nombre = condominio.getNombre();
        this.numeroCond = condominio.getNumeroCond();
    }

    public String getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(String idCondominio) {
        this.idCondominio = idCondominio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNumeroCond() {
        return numeroCond;
    }

    public void setNumeroCond(long numeroCond) {
        this.numeroCond = numeroCond;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MCondominio)) return false;
        MCondominio that = (MCondominio) o;
        return getNumeroCond() == that.getNumeroCond() &&
                Objects.equals(getIdCondominio(), that.getIdCondominio()) &&
                Objects.equals(getNombre(), that.getNombre());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdCondominio(), getNombre(), getNumeroCond());
    }

    @Override
    public String toString() {
        return "MCondominio{" +
                "idCondominio='" + idCondominio + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numeroCond=" + numeroCond +
                '}';
    }
}
