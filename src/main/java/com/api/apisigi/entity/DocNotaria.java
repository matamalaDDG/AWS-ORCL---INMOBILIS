package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DOC_NOTARIA", schema = "SIGIADMIN", catalog = "")
public class DocNotaria {
    private String idDocNotaria;
    private String nomNotario;
    private String descripcion;
    private String documento;
    private String idDocumento;

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

    @Basic
    @Column(name = "DOCUMENTO")
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Basic
    @Column(name = "ID_DOCUMENTO")
    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocNotaria that = (DocNotaria) o;
        return Objects.equals(idDocNotaria, that.idDocNotaria) &&
                Objects.equals(nomNotario, that.nomNotario) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(documento, that.documento) &&
                Objects.equals(idDocumento, that.idDocumento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDocNotaria, nomNotario, descripcion, documento, idDocumento);
    }
}
