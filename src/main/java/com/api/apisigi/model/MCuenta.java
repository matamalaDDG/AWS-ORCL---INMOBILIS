package com.api.apisigi.model;

import com.api.apisigi.entity.Cuenta;

import java.util.Objects;

public class MCuenta {

    private String idCuenta;
    private String usuario;
    private String password;

    public MCuenta() {
    }

    public MCuenta(Cuenta cuenta) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.password = password;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MCuenta)) return false;
        MCuenta mCuenta = (MCuenta) o;
        return Objects.equals(getIdCuenta(), mCuenta.getIdCuenta()) &&
                Objects.equals(getUsuario(), mCuenta.getUsuario()) &&
                Objects.equals(getPassword(), mCuenta.getPassword());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdCuenta(), getUsuario(), getPassword());
    }

    @Override
    public String toString() {
        return "MCuenta{" +
                "idCuenta='" + idCuenta + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
