package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO LIQDESUELDO
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")

public class LiquidacionSueldo {
    private String idLiqSuel;
    private String decripcion;
    private List<CapacidadEconomica> capacidadEconomica;
    private Documento documento;

    @Id
    @Column(name = "ID_LIQ_SUEL")
    public String getIdLiqSuel() {
        return idLiqSuel;
    }

    public void setIdLiqSuel(String idLiqSuel) {
        this.idLiqSuel = idLiqSuel;
    }

    @Basic
    @Column(name = "DECRIPCION")
    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiquidacionSueldo that = (LiquidacionSueldo) o;
        return Objects.equals(idLiqSuel, that.idLiqSuel) &&
                Objects.equals(decripcion, that.decripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLiqSuel, decripcion);
    }

    @OneToMany(mappedBy = "liquidacionsueldo")
    public List<CapacidadEconomica> getCapacidadEconomica() {
        return capacidadEconomica;
    }

    public void setCapacidadEconomica(List<CapacidadEconomica> capacidadEconomica) {
        this.capacidadEconomica = capacidadEconomica;
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false)
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}
