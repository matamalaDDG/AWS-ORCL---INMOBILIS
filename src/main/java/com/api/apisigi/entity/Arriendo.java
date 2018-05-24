package com.api.apisigi.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@NamedStoredProcedureQuery(
        name = "addAriendo_sp",
        procedureName = "",
        parameters = {
                @StoredProcedureParameter(name = "bookName", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "bookReleaseDate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "authorFirstname", mode = ParameterMode.IN, type = Time.class),
                @StoredProcedureParameter(name = "authorLastname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "authorLastname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "authorLastname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "idPreContrato", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "monto", mode = ParameterMode.IN, type = long.class),
                @StoredProcedureParameter(name = "idCorredor", mode = ParameterMode.IN, type = String.class),
        }
)
public class Arriendo {
    private String idArriendo;
    private String notificacion;
    private Time fechaArriendo;
    private String idConvenio;
    private String idAseguradora;
    private String idCapacidadEconomica;
    private String idPreContrato;
    private long monto;
    private String idCorredor;

    @Id
    @Column(name = "ID_ARRIENDO")
    public String getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(String idArriendo) {
        this.idArriendo = idArriendo;
    }

    @Basic
    @Column(name = "NOTIFICACION")
    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    @Basic
    @Column(name = "FECHA_ARRIENDO")
    public Time getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Time fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    @Basic
    @Column(name = "ID_CONVENIO")
    public String getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(String idConvenio) {
        this.idConvenio = idConvenio;
    }

    @Basic
    @Column(name = "ID_ASEGURADORA")
    public String getIdAseguradora() {
        return idAseguradora;
    }

    public void setIdAseguradora(String idAseguradora) {
        this.idAseguradora = idAseguradora;
    }

    @Basic
    @Column(name = "ID_CAPACIDAD_ECONOMICA")
    public String getIdCapacidadEconomica() {
        return idCapacidadEconomica;
    }

    public void setIdCapacidadEconomica(String idCapacidadEconomica) {
        this.idCapacidadEconomica = idCapacidadEconomica;
    }

    @Basic
    @Column(name = "ID_PRE_CONTRATO")
    public String getIdPreContrato() {
        return idPreContrato;
    }

    public void setIdPreContrato(String idPreContrato) {
        this.idPreContrato = idPreContrato;
    }

    @Basic
    @Column(name = "MONTO")
    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "ID_CORREDOR")
    public String getIdCorredor() {
        return idCorredor;
    }

    public void setIdCorredor(String idCorredor) {
        this.idCorredor = idCorredor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arriendo arriendo = (Arriendo) o;
        return monto == arriendo.monto &&
                Objects.equals(idArriendo, arriendo.idArriendo) &&
                Objects.equals(notificacion, arriendo.notificacion) &&
                Objects.equals(fechaArriendo, arriendo.fechaArriendo) &&
                Objects.equals(idConvenio, arriendo.idConvenio) &&
                Objects.equals(idAseguradora, arriendo.idAseguradora) &&
                Objects.equals(idCapacidadEconomica, arriendo.idCapacidadEconomica) &&
                Objects.equals(idPreContrato, arriendo.idPreContrato) &&
                Objects.equals(idCorredor, arriendo.idCorredor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idArriendo, notificacion, fechaArriendo, idConvenio, idAseguradora, idCapacidadEconomica, idPreContrato, monto, idCorredor);
    }
}
