package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "DOC_BANCO", schema = "SIGIADMIN", catalog = "")
public class DocBanco {
    private String idBanco;
    private String tipoPago;
    private long monto;
    private String banco;
    private String documento;
    private String idDocumento;
    private Documento documentoByIdDocumento;
    private Collection<Venta> ventasByIdBanco;

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
        DocBanco docBanco = (DocBanco) o;
        return monto == docBanco.monto &&
                Objects.equals(idBanco, docBanco.idBanco) &&
                Objects.equals(tipoPago, docBanco.tipoPago) &&
                Objects.equals(banco, docBanco.banco) &&
                Objects.equals(documento, docBanco.documento) &&
                Objects.equals(idDocumento, docBanco.idDocumento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBanco, tipoPago, monto, banco, documento, idDocumento);
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false)
    public Documento getDocumentoByIdDocumento() {
        return documentoByIdDocumento;
    }

    public void setDocumentoByIdDocumento(Documento documentoByIdDocumento) {
        this.documentoByIdDocumento = documentoByIdDocumento;
    }

    @OneToMany(mappedBy = "docBancoByIdBanco")
    public Collection<Venta> getVentasByIdBanco() {
        return ventasByIdBanco;
    }

    public void setVentasByIdBanco(Collection<Venta> ventasByIdBanco) {
        this.ventasByIdBanco = ventasByIdBanco;
    }
}
