package com.api.apisigi.model;

import com.api.apisigi.entity.Convenio;

import java.util.Objects;

public class MConvenio {

    private String idConvenio;
    private double dscto;
    private String idEmpresa;
    private String descripcion;
    private String tipoConvenio;

    public MConvenio() {
    }

    public MConvenio(Convenio convenio) {
        this.idConvenio = convenio.getIdConvenio();
        this.dscto = convenio.getDscto();
        this.idEmpresa = convenio.getIdEmpresa();
        this.descripcion = convenio.getDescripcion();
        this.tipoConvenio = convenio.getTipoConvenio();
    }

    public String getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(String idConvenio) {
        this.idConvenio = idConvenio;
    }

    public double getDscto() {
        return dscto;
    }

    public void setDscto(double dscto) {
        this.dscto = dscto;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(String tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MConvenio)) return false;
        MConvenio mConvenio = (MConvenio) o;
        return Double.compare(mConvenio.getDscto(), getDscto()) == 0 &&
                Objects.equals(getIdConvenio(), mConvenio.getIdConvenio()) &&
                Objects.equals(getIdEmpresa(), mConvenio.getIdEmpresa()) &&
                Objects.equals(getDescripcion(), mConvenio.getDescripcion()) &&
                Objects.equals(getTipoConvenio(), mConvenio.getTipoConvenio());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdConvenio(), getDscto(), getIdEmpresa(), getDescripcion(), getTipoConvenio());
    }

    @Override
    public String toString() {
        return "MConvenio{" +
                "idConvenio='" + idConvenio + '\'' +
                ", dscto=" + dscto +
                ", idEmpresa='" + idEmpresa + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipoConvenio='" + tipoConvenio + '\'' +
                '}';
    }
}
