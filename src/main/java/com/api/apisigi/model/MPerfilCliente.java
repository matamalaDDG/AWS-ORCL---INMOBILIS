package com.api.apisigi.model;

import com.api.apisigi.entity.PerfilCliente;

import java.util.Objects;

public class MPerfilCliente {
    private String idPerfil;
    private String nombre;
    private String apellido;
    private String correo;
    private String rut;
    private String tipoCliente;
    private String idCuenta;

    public MPerfilCliente() {
    }

    public MPerfilCliente(PerfilCliente perfilCliente) {
        this.idPerfil = perfilCliente.getIdPerfil();
        this.nombre = perfilCliente.getNombre();
        this.apellido = perfilCliente.getApellido();
        this.correo = perfilCliente.getCorreo();
        this.rut = perfilCliente.getRut();
        this.tipoCliente = perfilCliente.getTipoCliente();
        this.idCuenta = perfilCliente.getIdCuenta();
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MPerfilCliente)) return false;
        MPerfilCliente that = (MPerfilCliente) o;
        return Objects.equals(getIdPerfil(), that.getIdPerfil()) &&
                Objects.equals(getNombre(), that.getNombre()) &&
                Objects.equals(getApellido(), that.getApellido()) &&
                Objects.equals(getCorreo(), that.getCorreo()) &&
                Objects.equals(getRut(), that.getRut()) &&
                Objects.equals(getTipoCliente(), that.getTipoCliente()) &&
                Objects.equals(getIdCuenta(), that.getIdCuenta());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdPerfil(), getNombre(), getApellido(), getCorreo(), getRut(), getTipoCliente(), getIdCuenta());
    }

    @Override
    public String toString() {
        return "MPerfilCliente{" +
                "idPerfil='" + idPerfil + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", rut='" + rut + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                ", idCuenta='" + idCuenta + '\'' +
                '}';
    }
}
