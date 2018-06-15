package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO CAPACIDAD ECONOMICA
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
@Table(name = "CAPACIDAD_ECONOMICA", schema = "SIGIADMIN", catalog = "")
public class CapacidadEconomica {
    private String idCapacidadEconomica;
    private String aval;
    private Collection<Arriendo> arriendo;
    private LiquidacionSueldo liquidacionsueldo;
    private Contrato contrato;
    private CedulaIdentidad cedulaidentidad;
    private BoletaHonorario boletahonorario;

    @Id
    @Column(name = "ID_CAPACIDAD_ECONOMICA")
    public String getIdCapacidadEconomica() {
        return idCapacidadEconomica;
    }

    public void setIdCapacidadEconomica(String idCapacidadEconomica) {
        this.idCapacidadEconomica = idCapacidadEconomica;
    }

    @Basic
    @Column(name = "AVAL")
    public String getAval() {
        return aval;
    }

    public void setAval(String aval) {
        this.aval = aval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CapacidadEconomica that = (CapacidadEconomica) o;
        return Objects.equals(idCapacidadEconomica, that.idCapacidadEconomica) &&
                Objects.equals(aval, that.aval);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCapacidadEconomica, aval);
    }

    @OneToMany(mappedBy = "capacidadeconomica")
    public Collection<Arriendo> getArriendo() {
        return arriendo;
    }

    public void setArriendo(Collection<Arriendo> arriendo) {
        this.arriendo = arriendo;
    }

    @ManyToOne
    @JoinColumn(name = "ID_LIQ_SUEL", referencedColumnName = "ID_LIQ_SUEL")
    public LiquidacionSueldo getLiquidacionsueldo() {
        return liquidacionsueldo;
    }

    public void setLiquidacionsueldo(LiquidacionSueldo liquidacionsueldo) {
        this.liquidacionsueldo = liquidacionsueldo;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CONTRATO", referencedColumnName = "ID_CONTRATO", nullable = false)
    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CEDULA", referencedColumnName = "ID_CEDULA", nullable = false)
    public CedulaIdentidad getCedulaidentidad() {
        return cedulaidentidad;
    }

    public void setCedulaidentidad(CedulaIdentidad cedulaidentidad) {
        this.cedulaidentidad = cedulaidentidad;
    }

    @ManyToOne
    @JoinColumn(name = "ID_BOLETA", referencedColumnName = "ID_BOLETA")
    public BoletaHonorario getBoletahonorario() {
        return boletahonorario;
    }

    public void setBoletahonorario(BoletaHonorario boletahonorario) {
        this.boletahonorario = boletahonorario;
    }
}
