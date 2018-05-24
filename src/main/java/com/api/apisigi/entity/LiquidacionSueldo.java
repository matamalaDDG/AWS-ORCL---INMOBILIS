package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LIQUIDACION_SUELDO", schema = "SIGIADMIN", catalog = "")
public class LiquidacionSueldo {
    private String idLiqSuel;
    private String decripcion;
    private String idDocumento;

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

    @Basic
    @Column(name = "ID_DOCUMENTO")
    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiquidacionSueldo that = (LiquidacionSueldo) o;
        return Objects.equals(idLiqSuel, that.idLiqSuel) &&
                Objects.equals(decripcion, that.decripcion) &&
                Objects.equals(idDocumento, that.idDocumento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLiqSuel, decripcion, idDocumento);
    }
}
