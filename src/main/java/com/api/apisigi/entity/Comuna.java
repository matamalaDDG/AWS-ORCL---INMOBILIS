package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Comuna {
    private String idComuna;
    private String comuna;
    private Region region;
    private Collection<Propiedad> propiedad;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comuna comuna1 = (Comuna) o;
        return Objects.equals(idComuna, comuna1.idComuna) &&
                Objects.equals(comuna, comuna1.comuna);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idComuna, comuna);
    }

    @ManyToOne
    @JoinColumn(name = "ID_REGION", referencedColumnName = "ID_REGION", nullable = false)
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @OneToMany(mappedBy = "comuna")
    public Collection<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Collection<Propiedad> propiedad) {
        this.propiedad = propiedad;
    }
}
