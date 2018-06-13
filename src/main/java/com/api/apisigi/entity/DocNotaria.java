package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO DOCNOTARIA
@Entity
@Table(name = "DOC_NOTARIA", schema = "SIGIADMIN", catalog = "")
public class DocNotaria {
    private String idDocNotaria;
    private String nomNotario;
    private String descripcion;
    private Documento documento;
    private Collection<Notaria> notaria;
    private Collection<Venta> venta;

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

    @OneToMany(mappedBy = "docNotaria")
    public Collection<Notaria> getNotaria() {
        return notaria;
    }

    public void setNotaria(Collection<Notaria> notaria) {
        this.notaria = notaria;
    }

    @OneToMany(mappedBy = "docnotaria")
    public Collection<Venta> getVenta() {
        return venta;
    }

    public void setVenta(Collection<Venta> venta) {
        this.venta = venta;
    }
}
