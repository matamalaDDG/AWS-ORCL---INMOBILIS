package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO CEDULA IDENTIDAD
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
@Table(name = "CEDULA_IDENTIDAD", schema = "SIGIADMIN", catalog = "")
public class CedulaIdentidad {
    private String idCedula;
    private String descripcion;
    private Collection<CapacidadEconomica> capacidadeconomica;
    private Documento documento;

    @Id
    @Column(name = "ID_CEDULA")
    public String getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(String idCedula) {
        this.idCedula = idCedula;
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
        CedulaIdentidad that = (CedulaIdentidad) o;
        return Objects.equals(idCedula, that.idCedula) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCedula, descripcion);
    }

    @OneToMany(mappedBy = "cedulaidentidad")
    public Collection<CapacidadEconomica> getCapacidadeconomica() {
        return capacidadeconomica;
    }

    public void setCapacidadeconomica(Collection<CapacidadEconomica> capacidadeconomica) {
        this.capacidadeconomica = capacidadeconomica;
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
