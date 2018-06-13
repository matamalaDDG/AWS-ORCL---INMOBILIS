package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO CUENTA
@Entity
public class Cuenta {
    private String idCuenta;
    private String usuario;
    private String password;
    private Collection<PerfilCliente> perfilcliente;

    @Id
    @Column(name = "ID_CUENTA")
    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Basic
    @Column(name = "USUARIO")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(idCuenta, cuenta.idCuenta) &&
                Objects.equals(usuario, cuenta.usuario) &&
                Objects.equals(password, cuenta.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCuenta, usuario, password);
    }

    @OneToMany(mappedBy = "cuenta")
    public Collection<PerfilCliente> getPerfilcliente() {
        return perfilcliente;
    }

    public void setPerfilcliente(Collection<PerfilCliente> perfilcliente) {
        this.perfilcliente = perfilcliente;
    }
}
