package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO CONDOMINIO
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class Condominio {
    private String idCondominio;
    private String nombre;
    private long numeroCond;
    private List<Casa> casa;

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

    @OneToMany(mappedBy = "condominio")
    public List<Casa> getCasa() {
        return casa;
    }

    public void setCasa(List<Casa> casa) {
        this.casa = casa;
    }
}
