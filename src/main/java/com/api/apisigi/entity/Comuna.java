package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Comuna {
    private String idComuna;
    private String comuna;
    private String idRegion;
    private Region regionByIdRegion;
    private Collection<Propiedad> propiedadsByIdComuna;

    @Id
    @Column(name = "ID_COMUNA")
    public String getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(String idComuna) {
        this.idComuna = idComuna;
    }

    @Basic
    @Column(name = "COMUNA")
    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    @Basic
    @Column(name = "ID_REGION")
    public String getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comuna comuna1 = (Comuna) o;
        return Objects.equals(idComuna, comuna1.idComuna) &&
                Objects.equals(comuna, comuna1.comuna) &&
                Objects.equals(idRegion, comuna1.idRegion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idComuna, comuna, idRegion);
    }

    @ManyToOne
    @JoinColumn(name = "ID_REGION", referencedColumnName = "ID_REGION", nullable = false)
    public Region getRegionByIdRegion() {
        return regionByIdRegion;
    }

    public void setRegionByIdRegion(Region regionByIdRegion) {
        this.regionByIdRegion = regionByIdRegion;
    }

    @OneToMany(mappedBy = "comunaByIdComuna")
    public Collection<Propiedad> getPropiedadsByIdComuna() {
        return propiedadsByIdComuna;
    }

    public void setPropiedadsByIdComuna(Collection<Propiedad> propiedadsByIdComuna) {
        this.propiedadsByIdComuna = propiedadsByIdComuna;
    }
}
