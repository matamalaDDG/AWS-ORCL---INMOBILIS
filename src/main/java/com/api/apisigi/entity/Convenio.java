package com.api.apisigi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Convenio {
    private String idConvenio;
    private double dscto;
    private String idEmpresa;
    private String descripcion;
    private String tipoConvenio;

    @Id
    @Column(name = "ID_CONVENIO")
    public String getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(String idConvenio) {
        this.idConvenio = idConvenio;
    }

    @Basic
    @Column(name = "DSCTO")
    public double getDscto() {
        return dscto;
    }

    public void setDscto(double dscto) {
        this.dscto = dscto;
    }

    @Basic
    @Column(name = "ID_EMPRESA")
    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
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
    @Column(name = "TIPO_CONVENIO")
    public String getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(String tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Convenio convenio = (Convenio) o;
        return Double.compare(convenio.dscto, dscto) == 0 &&
                Objects.equals(idConvenio, convenio.idConvenio) &&
                Objects.equals(idEmpresa, convenio.idEmpresa) &&
                Objects.equals(descripcion, convenio.descripcion) &&
                Objects.equals(tipoConvenio, convenio.tipoConvenio);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idConvenio, dscto, idEmpresa, descripcion, tipoConvenio);
    }
}
