package com.api.apisigi.pruebaEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Propiedad {
    private String idPropiedad;
    private String direccion;
    private String tipoDueno;
    private String disponibilidad;
    private Comuna comunaByIdComuna;

    @Id
    @Column(name = "ID_PROPIEDAD")
    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    @Basic
    @Column(name = "DIRECCION")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "TIPO_DUENO")
    public String getTipoDueno() {
        return tipoDueno;
    }

    public void setTipoDueno(String tipoDueno) {
        this.tipoDueno = tipoDueno;
    }

    @Basic
    @Column(name = "DISPONIBILIDAD")
    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propiedad propiedad = (Propiedad) o;
        return Objects.equals(idPropiedad, propiedad.idPropiedad) &&
                Objects.equals(direccion, propiedad.direccion) &&
                Objects.equals(tipoDueno, propiedad.tipoDueno) &&
                Objects.equals(disponibilidad, propiedad.disponibilidad);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPropiedad, direccion, tipoDueno, disponibilidad);
    }

    @ManyToOne
    @JoinColumn(name = "ID_COMUNA", referencedColumnName = "ID_COMUNA", nullable = false)
    public Comuna getComunaByIdComuna() {
        return comunaByIdComuna;
    }

    public void setComunaByIdComuna(Comuna comunaByIdComuna) {
        this.comunaByIdComuna = comunaByIdComuna;
    }
}
