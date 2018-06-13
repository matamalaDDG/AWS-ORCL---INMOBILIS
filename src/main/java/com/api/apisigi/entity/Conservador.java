package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO CONSERVADOR
@Entity
public class Conservador {
    private String idDocConservador;
    private String nomConservador;
    private Documento documento;
    private Collection<Venta> venta;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conservador that = (Conservador) o;
        return Objects.equals(idDocConservador, that.idDocConservador) &&
                Objects.equals(nomConservador, that.nomConservador);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDocConservador, nomConservador);
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false)
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    @OneToMany(mappedBy = "conservador")
    public Collection<Venta> getVenta() {
        return venta;
    }

    public void setVenta(Collection<Venta> venta) {
        this.venta = venta;
    }
}
