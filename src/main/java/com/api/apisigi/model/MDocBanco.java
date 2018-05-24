package com.api.apisigi.model;

import com.api.apisigi.entity.DocBanco;

import java.util.Objects;

public class MDocBanco {

    private String idBanco;
    private String tipoPago;
    private long monto;
    private String banco;
    private String documento;
    private String idDocumento;

    public MDocBanco() {
    }

    public MDocBanco(DocBanco docbanco) {
        this.idBanco = docbanco.getIdBanco();
        this.tipoPago = docbanco.getTipoPago();
        this.monto = docbanco.getMonto();
        this.banco = docbanco.getBanco();
        this.documento = docbanco.getDocumento();
        this.idDocumento = docbanco.getIdDocumento();
    }

    public String getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(String idBanco) {
        this.idBanco = idBanco;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MDocBanco)) return false;
        MDocBanco mDocBanco = (MDocBanco) o;
        return getMonto() == mDocBanco.getMonto() &&
                Objects.equals(getIdBanco(), mDocBanco.getIdBanco()) &&
                Objects.equals(getTipoPago(), mDocBanco.getTipoPago()) &&
                Objects.equals(getBanco(), mDocBanco.getBanco()) &&
                Objects.equals(getDocumento(), mDocBanco.getDocumento()) &&
                Objects.equals(getIdDocumento(), mDocBanco.getIdDocumento());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdBanco(), getTipoPago(), getMonto(), getBanco(), getDocumento(), getIdDocumento());
    }

    @Override
    public String toString() {
        return "MDocBanco{" +
                "idBanco='" + idBanco + '\'' +
                ", tipoPago='" + tipoPago + '\'' +
                ", monto=" + monto +
                ", banco='" + banco + '\'' +
                ", documento='" + documento + '\'' +
                ", idDocumento='" + idDocumento + '\'' +
                '}';
    }
}
