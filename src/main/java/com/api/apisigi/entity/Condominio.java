package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Condominio {
    private String idCondominio;
    private String nombre;
    private long numeroCond;
    private Collection<Casa> casasByIdCondominio;

    @Id
    @Column(name = "ID_CONDOMINIO")
    public String getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(String idCondominio) {
        this.idCondominio = idCondominio;
    }

    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "NUMERO_COND")
    public long getNumeroCond() {
        return numeroCond;
    }

    public void setNumeroCond(long numeroCond) {
        this.numeroCond = numeroCond;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condominio that = (Condominio) o;
        return numeroCond == that.numeroCond &&
                Objects.equals(idCondominio, that.idCondominio) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCondominio, nombre, numeroCond);
    }

    @OneToMany(mappedBy = "condominioByIdCondominio")
    public Collection<Casa> getCasasByIdCondominio() {
        return casasByIdCondominio;
    }

    public void setCasasByIdCondominio(Collection<Casa> casasByIdCondominio) {
        this.casasByIdCondominio = casasByIdCondominio;
    }
}
