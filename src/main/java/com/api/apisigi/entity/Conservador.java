package com.api.apisigi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Conservador {
    private String idDocConservador;
    private String nomConservador;
    private String documento;
    private String idDocumento;

    @Id
    @Column(name = "ID_DOC_CONSERVADOR")
    public String getIdDocConservador() {
        return idDocConservador;
    }

    public void setIdDocConservador(String idDocConservador) {
        this.idDocConservador = idDocConservador;
    }

    @Basic
    @Column(name = "NOM_CONSERVADOR")
    public String getNomConservador() {
        return nomConservador;
    }

    public void setNomConservador(String nomConservador) {
        this.nomConservador = nomConservador;
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
        Conservador that = (Conservador) o;
        return Objects.equals(idDocConservador, that.idDocConservador) &&
                Objects.equals(nomConservador, that.nomConservador) &&
                Objects.equals(documento, that.documento) &&
                Objects.equals(idDocumento, that.idDocumento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDocConservador, nomConservador, documento, idDocumento);
    }
}
