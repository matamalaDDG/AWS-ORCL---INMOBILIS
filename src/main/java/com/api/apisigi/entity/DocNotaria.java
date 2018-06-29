package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO DOCNOTARIA
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class DocNotaria {
    private String idDocNotaria;
    private String nomNotario;
    private String descripcion;
    private Documento documento;

    private List<Venta> venta;

    @Id
    @Column(name = "ID_DOC_NOTARIA")
    public String getIdDocNotaria() {
        return idDocNotaria;
    }

    public void setIdDocNotaria(String idDocNotaria) {
        this.idDocNotaria = idDocNotaria;
    }

    @Basic
    @Column(name = "NOM_NOTARIO")
    public String getNomNotario() {
        return nomNotario;
    }

    public void setNomNotario(String nomNotario) {
        this.nomNotario = nomNotario;
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
        DocNotaria that = (DocNotaria) o;
        return Objects.equals(idDocNotaria, that.idDocNotaria) &&
                Objects.equals(nomNotario, that.nomNotario) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDocNotaria, nomNotario, descripcion);
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false)
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    @OneToMany(mappedBy = "docnotaria")
    public List<Venta> getVenta() {
        return venta;
    }

    public void setVenta(List<Venta> venta) {
        this.venta = venta;
    }
}
