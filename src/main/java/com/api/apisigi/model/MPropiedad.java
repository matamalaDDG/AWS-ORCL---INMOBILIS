package com.api.apisigi.model;

import com.api.apisigi.entity.Propiedad;

import java.util.Objects;

public class MPropiedad {

    private String idPropiedad;
    private String direccion;
    private String tipoDueno;
    private String disponibilidad;
    private String idEstado;
    private String idTipoProp;
    private String idComuna;
    private String idOficina;
    private String idCasa;
    private String idVenta;
    private String idDepto;
    private String idEstacionamiento;
    private String idArriendo;
    private String idPerfil;

    public MPropiedad() {
    }

    public MPropiedad(Propiedad propiedad) {
        this.idPropiedad = propiedad.getIdPropiedad();
        this.direccion = propiedad.getDireccion();
        this.tipoDueno = propiedad.getTipoDueno();
        this.disponibilidad = propiedad.getDisponibilidad();
        this.idEstado = propiedad.getIdEstado();
        this.idTipoProp = propiedad.getIdTipoProp();
        this.idComuna = propiedad.getIdComuna();
        this.idOficina = propiedad.getIdOficina();
        this.idCasa = propiedad.getIdCasa();
        this.idVenta = propiedad.getIdVenta();
        this.idDepto = propiedad.getIdDepto();
        this.idEstacionamiento = propiedad.getIdEstacionamiento();
        this.idArriendo = propiedad.getIdArriendo();
        this.idPerfil = propiedad.getIdPerfil();
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoDueno() {
        return tipoDueno;
    }

    public void setTipoDueno(String tipoDueno) {
        this.tipoDueno = tipoDueno;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getIdTipoProp() {
        return idTipoProp;
    }

    public void setIdTipoProp(String idTipoProp) {
        this.idTipoProp = idTipoProp;
    }

    public String getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(String idComuna) {
        this.idComuna = idComuna;
    }

    public String getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(String idOficina) {
        this.idOficina = idOficina;
    }

    public String getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(String idCasa) {
        this.idCasa = idCasa;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(String idDepto) {
        this.idDepto = idDepto;
    }

    public String getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public void setIdEstacionamiento(String idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    public String getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(String idArriendo) {
        this.idArriendo = idArriendo;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MPropiedad)) return false;
        MPropiedad that = (MPropiedad) o;
        return Objects.equals(getIdPropiedad(), that.getIdPropiedad()) &&
                Objects.equals(getDireccion(), that.getDireccion()) &&
                Objects.equals(getTipoDueno(), that.getTipoDueno()) &&
                Objects.equals(getDisponibilidad(), that.getDisponibilidad()) &&
                Objects.equals(getIdEstado(), that.getIdEstado()) &&
                Objects.equals(getIdTipoProp(), that.getIdTipoProp()) &&
                Objects.equals(getIdComuna(), that.getIdComuna()) &&
                Objects.equals(getIdOficina(), that.getIdOficina()) &&
                Objects.equals(getIdCasa(), that.getIdCasa()) &&
                Objects.equals(getIdVenta(), that.getIdVenta()) &&
                Objects.equals(getIdDepto(), that.getIdDepto()) &&
                Objects.equals(getIdEstacionamiento(), that.getIdEstacionamiento()) &&
                Objects.equals(getIdArriendo(), that.getIdArriendo()) &&
                Objects.equals(getIdPerfil(), that.getIdPerfil());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdPropiedad(), getDireccion(), getTipoDueno(), getDisponibilidad(), getIdEstado(), getIdTipoProp(), getIdComuna(), getIdOficina(), getIdCasa(), getIdVenta(), getIdDepto(), getIdEstacionamiento(), getIdArriendo(), getIdPerfil());
    }

    @Override
    public String toString() {
        return "MPropiedad{" +
                "idPropiedad='" + idPropiedad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tipoDueno='" + tipoDueno + '\'' +
                ", disponibilidad='" + disponibilidad + '\'' +
                ", idEstado='" + idEstado + '\'' +
                ", idTipoProp='" + idTipoProp + '\'' +
                ", idComuna='" + idComuna + '\'' +
                ", idOficina='" + idOficina + '\'' +
                ", idCasa='" + idCasa + '\'' +
                ", idVenta='" + idVenta + '\'' +
                ", idDepto='" + idDepto + '\'' +
                ", idEstacionamiento='" + idEstacionamiento + '\'' +
                ", idArriendo='" + idArriendo + '\'' +
                ", idPerfil='" + idPerfil + '\'' +
                '}';
    }
}


