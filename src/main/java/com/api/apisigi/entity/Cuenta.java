package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;


//TODO PROCEDIMIENTO ALMACENADO CUENTA
@Entity
public class Cuenta {

    private String idCuenta;
    private String usuario;
    private String password;
    private int isEnabled;
    private List<PerfilCliente> perfilcliente;
    private Roles roles;


    public Cuenta() {
    }


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
    @Column(name = "CONTRASENA")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "ISENABLED")
    public int getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(int isEnabled) {
        this.isEnabled = isEnabled;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "cuenta")
    public List<PerfilCliente> getPerfilcliente() {
        return perfilcliente;
    }

    public void setPerfilcliente(List<PerfilCliente> perfilcliente) {
        this.perfilcliente = perfilcliente;
    }

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "IDROL", referencedColumnName = "IDROL", nullable = false)
    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "idCuenta='" + idCuenta + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", perfilcliente=" + perfilcliente +
                '}';
    }
}
