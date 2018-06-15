package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO TASACION
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class Tasacion {
    private String idTasacion;
    private long monto;
    private String nomTasador;
    private String descripcion;
    private Documento documento;
    private Collection<Venta> venta;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasacion tasacion = (Tasacion) o;
        return monto == tasacion.monto &&
                Objects.equals(idTasacion, tasacion.idTasacion) &&
                Objects.equals(nomTasador, tasacion.nomTasador) &&
                Objects.equals(descripcion, tasacion.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTasacion, monto, nomTasador, descripcion);
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false)
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    @OneToMany(mappedBy = "tasacion")
    public Collection<Venta> getVenta() {
        return venta;
    }

    public void setVenta(Collection<Venta> venta) {
        this.venta = venta;
    }
}
