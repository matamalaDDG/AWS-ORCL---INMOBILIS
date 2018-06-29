package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO COMUNA
@Entity
public class Comuna {
    private String idComuna;
    private String comuna;

    private Region region;

    private List<Propiedad> propiedad;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonManagedReference("region")
    @JoinColumn(name = "ID_REGION", referencedColumnName = "ID_REGION", nullable = false)
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }


    @OneToMany(mappedBy = "comuna",
            cascade = CascadeType.ALL,
            orphanRemoval = false)
    @JsonIgnore
    @JsonBackReference("propiedad")
    public List<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(List<Propiedad> propiedad) {
        this.propiedad = propiedad;
    }
}
