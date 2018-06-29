package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO PRECONTRATO
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class Precontrato {
    private String idPreContrato;
    private String estado;
    private String descripcion;
    private List<Arriendo> arriendo;
    private Documento documento;

    @Id
    @Column(name = "ID_PRE_CONTRATO")
    public String getIdPreContrato() {
        return idPreContrato;
    }

    public void setIdPreContrato(String idPreContrato) {
        this.idPreContrato = idPreContrato;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precontrato that = (Precontrato) o;
        return Objects.equals(idPreContrato, that.idPreContrato) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPreContrato, estado, descripcion);
    }

    @OneToMany(mappedBy = "precontrato")
    public List<Arriendo> getArriendo() {
        return arriendo;
    }

    public void setArriendo(List<Arriendo> arriendo) {
        this.arriendo = arriendo;
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false)
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}
