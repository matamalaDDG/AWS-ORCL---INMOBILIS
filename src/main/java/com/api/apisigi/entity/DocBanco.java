package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO DOCBANCO
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class DocBanco {
    private String idBanco;
    private String tipoPago;
    private long monto;
    private String banco;
    private Documento documento;
    private List<Venta> venta;

    @Id
    @Column(name = "ID_BANCO")
    public String getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(String idBanco) {
        this.idBanco = idBanco;
    }

    @Basic
    @Column(name = "TIPO_PAGO")
    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
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
    @Column(name = "BANCO")
    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocBanco docBanco = (DocBanco) o;
        return monto == docBanco.monto &&
                Objects.equals(idBanco, docBanco.idBanco) &&
                Objects.equals(tipoPago, docBanco.tipoPago) &&
                Objects.equals(banco, docBanco.banco);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBanco, tipoPago, monto, banco);
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false)
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    @OneToMany(mappedBy = "docbanco")
    public List<Venta> getVenta() {
        return venta;
    }

    public void setVenta(List<Venta> venta) {
        this.venta = venta;
    }
}
