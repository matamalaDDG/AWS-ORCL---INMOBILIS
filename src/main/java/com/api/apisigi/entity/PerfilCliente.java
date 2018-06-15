package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO PERFILCLIENTE
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
@Table(name = "PERFIL_CLIENTE", schema = "SIGIADMIN", catalog = "")
public class PerfilCliente {
    private String idPerfil;
    private String nombre;
    private String apellido;
    private String correo;
    private String rut;
    private String tipoCliente;
    private Collection<Corredor> corredor;
    private Cuenta cuenta;
    private Collection<Propiedad> propiedad;

    @Id
    @Column(name = "ID_PERFIL")
    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "APELLIDO")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "CORREO")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "RUT")
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    @Basic
    @Column(name = "TIPO_CLIENTE")
    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerfilCliente that = (PerfilCliente) o;
        return Objects.equals(idPerfil, that.idPerfil) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(apellido, that.apellido) &&
                Objects.equals(correo, that.correo) &&
                Objects.equals(rut, that.rut) &&
                Objects.equals(tipoCliente, that.tipoCliente);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPerfil, nombre, apellido, correo, rut, tipoCliente);
    }

    @OneToMany(mappedBy = "perfilcliente")
    public Collection<Corredor> getCorredor() {
        return corredor;
    }

    public void setCorredor(Collection<Corredor> corredor) {
        this.corredor = corredor;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CUENTA", referencedColumnName = "ID_CUENTA", nullable = false)
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @OneToMany(mappedBy = "perfilcliente")
    public Collection<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Collection<Propiedad> propiedad) {
        this.propiedad = propiedad;
    }
}
