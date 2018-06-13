package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO CONVENIO
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class Convenio {
    private String idConvenio;
    private double dscto;
    private String descripcion;
    private String tipoConvenio;
    private Empresas empresa;

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
                Objects.equals(descripcion, convenio.descripcion) &&
                Objects.equals(tipoConvenio, convenio.tipoConvenio);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idConvenio, dscto, descripcion, tipoConvenio);
    }

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA", nullable = false)
    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }
}
