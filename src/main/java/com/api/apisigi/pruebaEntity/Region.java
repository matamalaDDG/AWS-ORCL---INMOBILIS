package com.api.apisigi.pruebaEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Region {
    private String idRegion;
    private String region;
    private Collection<Comuna> comunasByIdRegion;

    public Region() {
    }

    public Region( String idRegion, String region, Collection<Comuna> comunasByIdRegion) {
        this.idRegion = idRegion;
        this.region = region;
        this.comunasByIdRegion = comunasByIdRegion;
    }

    @Id
    @Column(name = "ID_REGION")
    public String getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
    }

    @Basic
    @Column(name = "REGION")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region1 = (Region) o;
        return Objects.equals(idRegion, region1.idRegion) &&
                Objects.equals(region, region1.region);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRegion, region);
    }

    @OneToMany(mappedBy = "regionByIdRegion")
    public Collection<Comuna> getComunasByIdRegion() {
        return comunasByIdRegion;
    }

    public void setComunasByIdRegion(Collection<Comuna> comunasByIdRegion) {
        this.comunasByIdRegion = comunasByIdRegion;
    }
}
