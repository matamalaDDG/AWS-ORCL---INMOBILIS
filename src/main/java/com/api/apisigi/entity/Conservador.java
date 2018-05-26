package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Conservador {
    private String idDocConservador;
    private String nomConservador;
    private String doc;
    private Documento documento;
    private Collection<Venta> ventasByIdDocConservador;

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
    @Column(name = "ID_DOCUMENTO")
    public String getDoc() {
        return doc;
    }

    public void setDoc(String idDocumento) {
        this.doc = idDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conservador that = (Conservador) o;
        return Objects.equals(idDocConservador, that.idDocConservador) &&
                Objects.equals(nomConservador, that.nomConservador) &&
                Objects.equals(doc, that.doc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDocConservador, nomConservador, doc);
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false)
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documentoByIdDocumento) {
        this.documento = documentoByIdDocumento;
    }

    @OneToMany(mappedBy = "conservadorByIdDocConservador")
    public Collection<Venta> getVentasByIdDocConservador() {
        return ventasByIdDocConservador;
    }

    public void setVentasByIdDocConservador(Collection<Venta> ventasByIdDocConservador) {
        this.ventasByIdDocConservador = ventasByIdDocConservador;
    }
}
