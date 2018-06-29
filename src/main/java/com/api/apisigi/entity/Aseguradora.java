package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")

public class Aseguradora {
    private String idAseguradora;
    private String tipoSeguro;
    private String aseguradora;
    private List<Arriendo> arriendo;

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

    @OneToMany(mappedBy = "aseguradora")
    public List<Arriendo> getArriendo() {
        return arriendo;
    }

    public void setArriendo(List<Arriendo> arriendo) {
        this.arriendo = arriendo;
    }
}
