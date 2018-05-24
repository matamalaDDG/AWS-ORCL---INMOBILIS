package com.api.apisigi.model;

import com.api.apisigi.entity.Arriendo;

import java.sql.Time;
import java.util.Objects;

public class MArriendo {
    private String idArriendo;
    private String notificacion;
    private Time fechaArriendo;
    private String idConvenio;
    private String idAseguradora;
    private String idCapacidadEconomica;
    private String idPreContrato;
    private long monto;
    private String idCorredor;

    public MArriendo() {
    }

    public MArriendo(Arriendo arriendo) {
        this.idArriendo = arriendo.getIdArriendo();
        this.notificacion = arriendo.getNotificacion();
        this.fechaArriendo = arriendo.getFechaArriendo();
        this.idConvenio = arriendo.getIdConvenio();
        this.idAseguradora = arriendo.getIdAseguradora();
        this.idCapacidadEconomica = arriendo.getIdCapacidadEconomica();
        this.idPreContrato = arriendo.getIdPreContrato();
        this.monto = arriendo.getMonto();
        this.idCorredor = arriendo.getIdCorredor();
    }

    public String getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(String idArriendo) {
        this.idArriendo = idArriendo;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public Time getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Time fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public String getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(String idConvenio) {
        this.idConvenio = idConvenio;
    }

    public String getIdAseguradora() {
        return idAseguradora;
    }

    public void setIdAseguradora(String idAseguradora) {
        this.idAseguradora = idAseguradora;
    }

    public String getIdCapacidadEconomica() {
        return idCapacidadEconomica;
    }

    public void setIdCapacidadEconomica(String idCapacidadEconomica) {
        this.idCapacidadEconomica = idCapacidadEconomica;
    }

    public String getIdPreContrato() {
        return idPreContrato;
    }

    public void setIdPreContrato(String idPreContrato) {
        this.idPreContrato = idPreContrato;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getIdCorredor() {
        return idCorredor;
    }

    public void setIdCorredor(String idCorredor) {
        this.idCorredor = idCorredor;
    }

    @Override
    public String toString() {
        return "MArriendo{" +
                "idArriendo='" + idArriendo + '\'' +
                ", notificacion='" + notificacion + '\'' +
                ", fechaArriendo=" + fechaArriendo +
                ", idConvenio='" + idConvenio + '\'' +
                ", idAseguradora='" + idAseguradora + '\'' +
                ", idCapacidadEconomica='" + idCapacidadEconomica + '\'' +
                ", idPreContrato='" + idPreContrato + '\'' +
                ", monto=" + monto +
                ", idCorredor='" + idCorredor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MArriendo)) return false;
        MArriendo mArriendo = (MArriendo) o;
        return getMonto() == mArriendo.getMonto() &&
                Objects.equals(getIdArriendo(), mArriendo.getIdArriendo()) &&
                Objects.equals(getNotificacion(), mArriendo.getNotificacion()) &&
                Objects.equals(getFechaArriendo(), mArriendo.getFechaArriendo()) &&
                Objects.equals(getIdConvenio(), mArriendo.getIdConvenio()) &&
                Objects.equals(getIdAseguradora(), mArriendo.getIdAseguradora()) &&
                Objects.equals(getIdCapacidadEconomica(), mArriendo.getIdCapacidadEconomica()) &&
                Objects.equals(getIdPreContrato(), mArriendo.getIdPreContrato()) &&
                Objects.equals(getIdCorredor(), mArriendo.getIdCorredor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdArriendo(), getNotificacion(), getFechaArriendo(), getIdConvenio(), getIdAseguradora(), getIdCapacidadEconomica(), getIdPreContrato(), getMonto(), getIdCorredor());
    }
}
