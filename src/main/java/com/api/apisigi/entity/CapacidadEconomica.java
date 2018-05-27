package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CAPACIDAD_ECONOMICA", schema = "SIGIADMIN", catalog = "")
public class CapacidadEconomica {
    private String idCapacidadEconomica;
    private String aval;
    private String idLiqSuel;
    private String idContrato;
    private String idCedula;
    private String idBoleta;
    private Collection<Arriendo> arriendosByIdCapacidadEconomica;
    private LiquidacionSueldo liquidacionSueldoByIdLiqSuel;
    private Contrato contratoByIdContrato;
    private CedulaIdentidad cedulaIdentidadByIdCedula;
    private BoletaHonorario boletaHonorarioByIdBoleta;

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

    @Basic
    @Column(name = "ID_LIQ_SUEL")
    public String getIdLiqSuel() {
        return idLiqSuel;
    }

    public void setIdLiqSuel(String idLiqSuel) {
        this.idLiqSuel = idLiqSuel;
    }

    @Basic
    @Column(name = "ID_CONTRATO")
    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    @Basic
    @Column(name = "ID_CEDULA")
    public String getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(String idCedula) {
        this.idCedula = idCedula;
    }

    @Basic
    @Column(name = "ID_BOLETA")
    public String getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(String idBoleta) {
        this.idBoleta = idBoleta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CapacidadEconomica that = (CapacidadEconomica) o;
        return Objects.equals(idCapacidadEconomica, that.idCapacidadEconomica) &&
                Objects.equals(aval, that.aval) &&
                Objects.equals(idLiqSuel, that.idLiqSuel) &&
                Objects.equals(idContrato, that.idContrato) &&
                Objects.equals(idCedula, that.idCedula) &&
                Objects.equals(idBoleta, that.idBoleta);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCapacidadEconomica, aval, idLiqSuel, idContrato, idCedula, idBoleta);
    }

    @OneToMany(mappedBy = "capacidadEconomicaByIdCapacidadEconomica")
    public Collection<Arriendo> getArriendosByIdCapacidadEconomica() {
        return arriendosByIdCapacidadEconomica;
    }

    public void setArriendosByIdCapacidadEconomica(Collection<Arriendo> arriendosByIdCapacidadEconomica) {
        this.arriendosByIdCapacidadEconomica = arriendosByIdCapacidadEconomica;
    }

    @ManyToOne
    @JoinColumn(name = "ID_LIQ_SUEL", referencedColumnName = "ID_LIQ_SUEL")
    public LiquidacionSueldo getLiquidacionSueldoByIdLiqSuel() {
        return liquidacionSueldoByIdLiqSuel;
    }

    public void setLiquidacionSueldoByIdLiqSuel(LiquidacionSueldo liquidacionSueldoByIdLiqSuel) {
        this.liquidacionSueldoByIdLiqSuel = liquidacionSueldoByIdLiqSuel;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CONTRATO", referencedColumnName = "ID_CONTRATO", nullable = false)
    public Contrato getContratoByIdContrato() {
        return contratoByIdContrato;
    }

    public void setContratoByIdContrato(Contrato contratoByIdContrato) {
        this.contratoByIdContrato = contratoByIdContrato;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CEDULA", referencedColumnName = "ID_CEDULA", nullable = false)
    public CedulaIdentidad getCedulaIdentidadByIdCedula() {
        return cedulaIdentidadByIdCedula;
    }

    public void setCedulaIdentidadByIdCedula(CedulaIdentidad cedulaIdentidadByIdCedula) {
        this.cedulaIdentidadByIdCedula = cedulaIdentidadByIdCedula;
    }

    @ManyToOne
    @JoinColumn(name = "ID_BOLETA", referencedColumnName = "ID_BOLETA")
    public BoletaHonorario getBoletaHonorarioByIdBoleta() {
        return boletaHonorarioByIdBoleta;
    }

    public void setBoletaHonorarioByIdBoleta(BoletaHonorario boletaHonorarioByIdBoleta) {
        this.boletaHonorarioByIdBoleta = boletaHonorarioByIdBoleta;
    }
}
