package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Casa {
    private String idCasa;
    private long cantDorm;
    private long cantBanos;
    private long mtsHabConst;
    private long mtsPatConst;
    private Condominio condominio;
    private Collection<Propiedad> propiedad;

    @Id
    @Column(name = "ID_CASA")
    public String getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(String idCasa) {
        this.idCasa = idCasa;
    }

    @Basic
    @Column(name = "CANT_DORM")
    public long getCantDorm() {
        return cantDorm;
    }

    public void setCantDorm(long cantDorm) {
        this.cantDorm = cantDorm;
    }

    @Basic
    @Column(name = "CANT_BANOS")
    public long getCantBanos() {
        return cantBanos;
    }

    public void setCantBanos(long cantBanos) {
        this.cantBanos = cantBanos;
    }

    @Basic
    @Column(name = "MTS_HAB_CONST")
    public long getMtsHabConst() {
        return mtsHabConst;
    }

    public void setMtsHabConst(long mtsHabConst) {
        this.mtsHabConst = mtsHabConst;
    }

    @Basic
    @Column(name = "MTS_PAT_CONST")
    public long getMtsPatConst() {
        return mtsPatConst;
    }

    public void setMtsPatConst(long mtsPatConst) {
        this.mtsPatConst = mtsPatConst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casa casa = (Casa) o;
        return cantDorm == casa.cantDorm &&
                cantBanos == casa.cantBanos &&
                mtsHabConst == casa.mtsHabConst &&
                mtsPatConst == casa.mtsPatConst &&
                Objects.equals(idCasa, casa.idCasa);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCasa,  cantDorm, cantBanos, mtsHabConst, mtsPatConst);
    }

    @ManyToOne
    @JoinColumn(name = "ID_CONDOMINIO", referencedColumnName = "ID_CONDOMINIO")
    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominioByIdCondominio) {
        this.condominio = condominioByIdCondominio;
    }

    @OneToMany(mappedBy = "casaByIdCasa")
    public Collection<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Collection<Propiedad> propiedadsByIdCasa) {
        this.propiedad = propiedadsByIdCasa;
    }
}
