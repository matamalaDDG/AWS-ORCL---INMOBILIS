package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Empresas {
    private String idEmpresa;
    private String nombreEmpresa;
    private Collection<Convenio> convenio;

    @Id
    @Column(name = "ID_EMPRESA")
    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Basic
    @Column(name = "NOMBRE_EMPRESA")
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresas empresas = (Empresas) o;
        return Objects.equals(idEmpresa, empresas.idEmpresa) &&
                Objects.equals(nombreEmpresa, empresas.nombreEmpresa);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idEmpresa, nombreEmpresa);
    }

    @OneToMany(mappedBy = "empresa")
    public Collection<Convenio> getConvenio() {
        return convenio;
    }

    public void setConvenio(Collection<Convenio> convenio) {
        this.convenio = convenio;
    }
}
