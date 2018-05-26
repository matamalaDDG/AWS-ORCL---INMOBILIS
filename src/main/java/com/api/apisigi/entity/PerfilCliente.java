package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PERFIL_CLIENTE", schema = "SIGIADMIN", catalog = "")
public class PerfilCliente {
    private String idPerfil;
    private String nombre;
    private String apellido;
    private String correo;
    private String rut;
    private String tipoCliente;
    private String idCuenta;
    private Collection<Corredor> corredorsByIdPerfil;
    private Cuenta cuentaByIdCuenta;
    private Collection<Propiedad> propiedadsByIdPerfil;

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

    @Basic
    @Column(name = "ID_CUENTA")
    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
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
                Objects.equals(tipoCliente, that.tipoCliente) &&
                Objects.equals(idCuenta, that.idCuenta);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPerfil, nombre, apellido, correo, rut, tipoCliente, idCuenta);
    }

    @OneToMany(mappedBy = "perfilClienteByIdPerfil")
    public Collection<Corredor> getCorredorsByIdPerfil() {
        return corredorsByIdPerfil;
    }

    public void setCorredorsByIdPerfil(Collection<Corredor> corredorsByIdPerfil) {
        this.corredorsByIdPerfil = corredorsByIdPerfil;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CUENTA", referencedColumnName = "ID_CUENTA", nullable = false)
    public Cuenta getCuentaByIdCuenta() {
        return cuentaByIdCuenta;
    }

    public void setCuentaByIdCuenta(Cuenta cuentaByIdCuenta) {
        this.cuentaByIdCuenta = cuentaByIdCuenta;
    }

    @OneToMany(mappedBy = "perfilClienteByIdPerfil")
    public Collection<Propiedad> getPropiedadsByIdPerfil() {
        return propiedadsByIdPerfil;
    }

    public void setPropiedadsByIdPerfil(Collection<Propiedad> propiedadsByIdPerfil) {
        this.propiedadsByIdPerfil = propiedadsByIdPerfil;
    }
}
