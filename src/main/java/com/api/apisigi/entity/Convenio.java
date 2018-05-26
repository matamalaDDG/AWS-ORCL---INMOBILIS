package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Convenio {
    private String idConvenio;
    private double dscto;
    private String idEmpresa;
    private String descripcion;
    private String tipoConvenio;
    private Collection<Arriendo> arriendosByIdConvenio;
    private Empresas empresasByIdEmpresa;
    private Collection<Venta> ventasByIdConvenio;

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

    @OneToMany(mappedBy = "convenioByIdConvenio")
    public Collection<Arriendo> getArriendosByIdConvenio() {
        return arriendosByIdConvenio;
    }

    public void setArriendosByIdConvenio(Collection<Arriendo> arriendosByIdConvenio) {
        this.arriendosByIdConvenio = arriendosByIdConvenio;
    }

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA", nullable = false)
    public Empresas getEmpresasByIdEmpresa() {
        return empresasByIdEmpresa;
    }

    public void setEmpresasByIdEmpresa(Empresas empresasByIdEmpresa) {
        this.empresasByIdEmpresa = empresasByIdEmpresa;
    }

    @OneToMany(mappedBy = "convenioByIdConvenio")
    public Collection<Venta> getVentasByIdConvenio() {
        return ventasByIdConvenio;
    }

    public void setVentasByIdConvenio(Collection<Venta> ventasByIdConvenio) {
        this.ventasByIdConvenio = ventasByIdConvenio;
    }
}
