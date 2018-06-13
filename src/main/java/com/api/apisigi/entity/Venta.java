package com.api.apisigi.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO VENTA
@Entity
public class Venta {
    private String idVenta;
    private long monto;
    private Time fechaCompra;
    private Collection<Propiedad> propiedad;
    private Servicios servicios;
    private Convenio convenio;
    private DocNotaria docnotaria;
    private Conservador conservador;
    private Tasacion tasacion;
    private DocBanco docbanco;
    private Corredor corredor;

    @Id
    @Column(name = "ID_VENTA")
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
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
    @Column(name = "FECHA_COMPRA")
    public Time getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Time fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return monto == venta.monto &&
                Objects.equals(idVenta, venta.idVenta) &&
                Objects.equals(fechaCompra, venta.fechaCompra);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idVenta, monto, fechaCompra);
    }

    @OneToMany(mappedBy = "venta")
    public Collection<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Collection<Propiedad> propiedad) {
        this.propiedad = propiedad;
    }

    @ManyToOne
    @JoinColumn(name = "ID_SERVICIO", referencedColumnName = "ID_SERVICIO")
    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CONVENIO", referencedColumnName = "ID_CONVENIO")
    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOC_NOTARIA", referencedColumnName = "ID_DOC_NOTARIA", nullable = false)
    public DocNotaria getDocnotaria() {
        return docnotaria;
    }

    public void setDocnotaria(DocNotaria docnotaria) {
        this.docnotaria = docnotaria;
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOC_CONSERVADOR", referencedColumnName = "ID_DOC_CONSERVADOR", nullable = false)
    public Conservador getConservador() {
        return conservador;
    }

    public void setConservador(Conservador conservador) {
        this.conservador = conservador;
    }

    @ManyToOne
    @JoinColumn(name = "ID_TASACION", referencedColumnName = "ID_TASACION", nullable = false)
    public Tasacion getTasacion() {
        return tasacion;
    }

    public void setTasacion(Tasacion tasacion) {
        this.tasacion = tasacion;
    }

    @ManyToOne
    @JoinColumn(name = "ID_BANCO", referencedColumnName = "ID_BANCO", nullable = false)
    public DocBanco getDocbanco() {
        return docbanco;
    }

    public void setDocbanco(DocBanco docbanco) {
        this.docbanco = docbanco;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CORREDOR", referencedColumnName = "ID_CORREDOR")
    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }
}
