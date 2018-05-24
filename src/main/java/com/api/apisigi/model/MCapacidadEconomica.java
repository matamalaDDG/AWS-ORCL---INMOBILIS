package com.api.apisigi.model;

import com.api.apisigi.entity.CapacidadEconomica;

import java.util.Objects;

public class MCapacidadEconomica {
    private String idCapacidadEconomica;
    private String aval;
    private String idLiqSuel;
    private String idContrato;
    private String idCedula;
    private String idBoleta;

    public MCapacidadEconomica() {
    }

    public MCapacidadEconomica(CapacidadEconomica capacidadeconomica) {
        this.idCapacidadEconomica = capacidadeconomica.getIdCapacidadEconomica();
        this.aval = capacidadeconomica.getAval();
        this.idLiqSuel = capacidadeconomica.getIdLiqSuel();
        this.idContrato = capacidadeconomica.getIdContrato();
        this.idCedula = capacidadeconomica.getIdCedula();
        this.idBoleta = capacidadeconomica.getIdBoleta();
    }

    public String getIdCapacidadEconomica() {
        return idCapacidadEconomica;
    }

    public void setIdCapacidadEconomica(String idCapacidadEconomica) {
        this.idCapacidadEconomica = idCapacidadEconomica;
    }

    public String getAval() {
        return aval;
    }

    public void setAval(String aval) {
        this.aval = aval;
    }

    public String getIdLiqSuel() {
        return idLiqSuel;
    }

    public void setIdLiqSuel(String idLiqSuel) {
        this.idLiqSuel = idLiqSuel;
    }

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    public String getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(String idCedula) {
        this.idCedula = idCedula;
    }

    public String getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(String idBoleta) {
        this.idBoleta = idBoleta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MCapacidadEconomica)) return false;
        MCapacidadEconomica that = (MCapacidadEconomica) o;
        return Objects.equals(getIdCapacidadEconomica(), that.getIdCapacidadEconomica()) &&
                Objects.equals(getAval(), that.getAval()) &&
                Objects.equals(getIdLiqSuel(), that.getIdLiqSuel()) &&
                Objects.equals(getIdContrato(), that.getIdContrato()) &&
                Objects.equals(getIdCedula(), that.getIdCedula()) &&
                Objects.equals(getIdBoleta(), that.getIdBoleta());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdCapacidadEconomica(), getAval(), getIdLiqSuel(), getIdContrato(), getIdCedula(), getIdBoleta());
    }

    @Override
    public String toString() {
        return "MCapacidadEconomica{" +
                "idCapacidadEconomica='" + idCapacidadEconomica + '\'' +
                ", aval='" + aval + '\'' +
                ", idLiqSuel='" + idLiqSuel + '\'' +
                ", idContrato='" + idContrato + '\'' +
                ", idCedula='" + idCedula + '\'' +
                ", idBoleta='" + idBoleta + '\'' +
                '}';
    }
}
