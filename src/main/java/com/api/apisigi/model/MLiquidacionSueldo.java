package com.api.apisigi.model;

import com.api.apisigi.entity.LiquidacionSueldo;

import java.util.Objects;

public class MLiquidacionSueldo {

    private String idLiqSuel;
    private String decripcion;
    private String idDocumento;

    public MLiquidacionSueldo() {
    }

    public MLiquidacionSueldo(LiquidacionSueldo liquidacionsueldo) {
        this.idLiqSuel = liquidacionsueldo.getIdLiqSuel();
        this.decripcion = liquidacionsueldo.getDecripcion();
        this.idDocumento = liquidacionsueldo.getIdDocumento();
    }

    public String getIdLiqSuel() {
        return idLiqSuel;
    }

    public void setIdLiqSuel(String idLiqSuel) {
        this.idLiqSuel = idLiqSuel;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MLiquidacionSueldo)) return false;
        MLiquidacionSueldo that = (MLiquidacionSueldo) o;
        return Objects.equals(getIdLiqSuel(), that.getIdLiqSuel()) &&
                Objects.equals(getDecripcion(), that.getDecripcion()) &&
                Objects.equals(getIdDocumento(), that.getIdDocumento());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdLiqSuel(), getDecripcion(), getIdDocumento());
    }

    @Override
    public String toString() {
        return "MLiquidacionSueldo{" +
                "idLiqSuel='" + idLiqSuel + '\'' +
                ", decripcion='" + decripcion + '\'' +
                ", idDocumento='" + idDocumento + '\'' +
                '}';
    }
}
