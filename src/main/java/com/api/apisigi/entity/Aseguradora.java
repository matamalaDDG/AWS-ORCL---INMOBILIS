package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Aseguradora {
    private String idAseguradora;
    private String tipoSeguro;
    private String aseguradora;
    private Collection<Arriendo> arriendosByIdAseguradora;

    @Id
    @Column(name = "ID_ASEGURADORA")
    public String getIdAseguradora() {
        return idAseguradora;
    }

    public void setIdAseguradora(String idAseguradora) {
        this.idAseguradora = idAseguradora;
    }

    @Basic
    @Column(name = "TIPO_SEGURO")
    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    @Basic
    @Column(name = "ASEGURADORA")
    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aseguradora that = (Aseguradora) o;
        return Objects.equals(idAseguradora, that.idAseguradora) &&
                Objects.equals(tipoSeguro, that.tipoSeguro) &&
                Objects.equals(aseguradora, that.aseguradora);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idAseguradora, tipoSeguro, aseguradora);
    }

    @OneToMany(mappedBy = "aseguradoraByIdAseguradora")
    public Collection<Arriendo> getArriendosByIdAseguradora() {
        return arriendosByIdAseguradora;
    }

    public void setArriendosByIdAseguradora(Collection<Arriendo> arriendosByIdAseguradora) {
        this.arriendosByIdAseguradora = arriendosByIdAseguradora;
    }
}
