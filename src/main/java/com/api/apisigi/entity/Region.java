package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO REGION

/*
@NamedNativeQueries({
  @NamedNativeQuery(
    name = "callGetAllFoos",
    query = "CALL GetAllFoos()",
    resultClass = Region.class)
})*/

@Entity
public class Region {
    private String idRegion;
    private String region;
    @JsonBackReference
    private List<Comuna> comuna;

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

    @JsonIgnore
    @OneToMany(mappedBy = "region",
            cascade = CascadeType.ALL,
            orphanRemoval = false)
    public List<Comuna> getComuna() {
        return comuna;
    }

    public void setComuna(List<Comuna> comuna) {
        this.comuna = comuna;
    }
}
