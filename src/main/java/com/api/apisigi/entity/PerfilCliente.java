package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO PERFILCLIENTE

@NamedStoredProcedureQuery(
		name = "proceso_usuarios_sp", // name of stored procedure in the persistence unit
		procedureName = "PROCESO_USUARIOS", //name of  stored procedure in the database
		parameters = //Parameters of the stored procedure
		{
            @StoredProcedureParameter(name = "nombre", mode = ParameterMode.IN, type = String.class),
            @StoredProcedureParameter(name = "apellido", mode = ParameterMode.IN, type = String.class),
            @StoredProcedureParameter(name = "correo", mode = ParameterMode.IN, type = String.class),
            @StoredProcedureParameter(name = "rut", mode = ParameterMode.IN, type = String.class),
            @StoredProcedureParameter(name = "tipoCliente", mode = ParameterMode.IN, type = String.class)
		}
)
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class PerfilCliente {

    private String idPerfil;
    private String nombre;
    private String apellido;
    private String correo;
    private String rut;
    private String tipoCliente;
    private Cuenta cuenta;
    private List<Propiedad> propiedad;

    public PerfilCliente() {
    }

    public PerfilCliente(String nombre, String apellido, String correo, String rut, String tipoCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.rut = rut;
        this.tipoCliente = tipoCliente;
    }



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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_CUENTA", referencedColumnName = "ID_CUENTA", nullable = false)
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "perfilcliente")
    public List<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(List<Propiedad> propiedad) {
        this.propiedad = propiedad;
    }
}
