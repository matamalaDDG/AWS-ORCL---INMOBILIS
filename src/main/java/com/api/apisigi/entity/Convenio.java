package com.api.apisigi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Convenio {
    private String idConvenio;
    private float dscto;
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
    public float getDscto() {
        return dscto;
    }

    public void setDscto(float dscto) {
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
        if (!(o instanceof Convenio)) return false;
        Convenio convenio = (Convenio) o;
        return Float.compare(convenio.getDscto(), getDscto()) == 0 &&
                Objects.equals(getIdConvenio(), convenio.getIdConvenio()) &&
                Objects.equals(getIdEmpresa(), convenio.getIdEmpresa()) &&
                Objects.equals(getDescripcion(), convenio.getDescripcion()) &&
                Objects.equals(getTipoConvenio(), convenio.getTipoConvenio());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdConvenio(), getDscto(), getIdEmpresa(), getDescripcion(), getTipoConvenio());
    }
}
