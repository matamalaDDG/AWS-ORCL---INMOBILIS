package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ROL_CUENTA")
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class Roles {

    private String idroles;
    private String rol;
    private List<Cuenta> cuentas;

    public Roles() {
    }

    @Id
    @Column(name = "IDROL")
    public String getIdroles() {
        return idroles;
    }


    public void setIdroles(String idroles) {
        this.idroles = idroles;
    }

    @Basic
    @Column(name = "ROL")
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "roles")
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roles)) return false;
        Roles roles = (Roles) o;
        return Objects.equals(getIdroles(), roles.getIdroles()) &&
                Objects.equals(getRol(), roles.getRol()) &&
                Objects.equals(getCuentas(), roles.getCuentas());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdroles(), getRol(), getCuentas());
    }

    @Override
    public String toString() {
        return "Roles{" +
                "idroles='" + idroles + '\'' +
                ", rol='" + rol + '\'' +
                ", cuentas=" + cuentas +
                '}';
    }
}
