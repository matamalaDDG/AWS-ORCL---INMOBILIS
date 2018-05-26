package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tasacion {
    private String idTasacion;
    private long monto;
    private String nomTasador;
    private String descripcion;
    private String documento;
    private String idDocumento;
    private Documento documentoByIdDocumento;
    private Collection<Venta> ventasByIdTasacion;

    @Id
    @Column(name = "ID_TASACION")
    public String getIdTasacion() {
        return idTasacion;
    }

    public void setIdTasacion(String idTasacion) {
        this.idTasacion = idTasacion;
    }

    @Basic
    @Column(name = "MONTO")
    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "NOM_TASADOR")
    public String getNomTasador() {
        return nomTasador;
    }

    public void setNomTasador(String nomTasador) {
        this.nomTasador = nomTasador;
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
        Tasacion tasacion = (Tasacion) o;
        return monto == tasacion.monto &&
                Objects.equals(idTasacion, tasacion.idTasacion) &&
                Objects.equals(nomTasador, tasacion.nomTasador) &&
                Objects.equals(descripcion, tasacion.descripcion) &&
                Objects.equals(documento, tasacion.documento) &&
                Objects.equals(idDocumento, tasacion.idDocumento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTasacion, monto, nomTasador, descripcion, documento, idDocumento);
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false)
    public Documento getDocumentoByIdDocumento() {
        return documentoByIdDocumento;
    }

    public void setDocumentoByIdDocumento(Documento documentoByIdDocumento) {
        this.documentoByIdDocumento = documentoByIdDocumento;
    }

    @OneToMany(mappedBy = "tasacionByIdTasacion")
    public Collection<Venta> getVentasByIdTasacion() {
        return ventasByIdTasacion;
    }

    public void setVentasByIdTasacion(Collection<Venta> ventasByIdTasacion) {
        this.ventasByIdTasacion = ventasByIdTasacion;
    }
}
