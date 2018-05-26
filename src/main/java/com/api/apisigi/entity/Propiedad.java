package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Propiedad {
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
    private Collection<Bodega> bodegasByIdPropiedad;
    private Estado estadoByIdEstado;
    private TipoPropiedad tipoPropiedadByIdTipoProp;
    private Comuna comunaByIdComuna;
    private Oficina oficinaByIdOficina;
    private Casa casaByIdCasa;
    private Venta ventaByIdVenta;
    private Departamento departamentoByIdDepto;
    private Estacionamiento estacionamientoByIdEstacionamiento;
    private Arriendo arriendoByIdArriendo;
    private PerfilCliente perfilClienteByIdPerfil;

    @Id
    @Column(name = "ID_PROPIEDAD")
    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    @Basic
    @Column(name = "DIRECCION")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "TIPO_DUENO")
    public String getTipoDueno() {
        return tipoDueno;
    }

    public void setTipoDueno(String tipoDueno) {
        this.tipoDueno = tipoDueno;
    }

    @Basic
    @Column(name = "DISPONIBILIDAD")
    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Basic
    @Column(name = "ID_ESTADO")
    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    @Basic
    @Column(name = "ID_TIPO_PROP")
    public String getIdTipoProp() {
        return idTipoProp;
    }

    public void setIdTipoProp(String idTipoProp) {
        this.idTipoProp = idTipoProp;
    }

    @Basic
    @Column(name = "ID_COMUNA")
    public String getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(String idComuna) {
        this.idComuna = idComuna;
    }

    @Basic
    @Column(name = "ID_OFICINA")
    public String getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(String idOficina) {
        this.idOficina = idOficina;
    }

    @Basic
    @Column(name = "ID_CASA")
    public String getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(String idCasa) {
        this.idCasa = idCasa;
    }

    @Basic
    @Column(name = "ID_VENTA")
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    @Basic
    @Column(name = "ID_DEPTO")
    public String getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(String idDepto) {
        this.idDepto = idDepto;
    }

    @Basic
    @Column(name = "ID_ESTACIONAMIENTO")
    public String getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public void setIdEstacionamiento(String idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    @Basic
    @Column(name = "ID_ARRIENDO")
    public String getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(String idArriendo) {
        this.idArriendo = idArriendo;
    }

    @Basic
    @Column(name = "ID_PERFIL")
    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propiedad propiedad = (Propiedad) o;
        return Objects.equals(idPropiedad, propiedad.idPropiedad) &&
                Objects.equals(direccion, propiedad.direccion) &&
                Objects.equals(tipoDueno, propiedad.tipoDueno) &&
                Objects.equals(disponibilidad, propiedad.disponibilidad) &&
                Objects.equals(idEstado, propiedad.idEstado) &&
                Objects.equals(idTipoProp, propiedad.idTipoProp) &&
                Objects.equals(idComuna, propiedad.idComuna) &&
                Objects.equals(idOficina, propiedad.idOficina) &&
                Objects.equals(idCasa, propiedad.idCasa) &&
                Objects.equals(idVenta, propiedad.idVenta) &&
                Objects.equals(idDepto, propiedad.idDepto) &&
                Objects.equals(idEstacionamiento, propiedad.idEstacionamiento) &&
                Objects.equals(idArriendo, propiedad.idArriendo) &&
                Objects.equals(idPerfil, propiedad.idPerfil);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPropiedad, direccion, tipoDueno, disponibilidad, idEstado, idTipoProp, idComuna, idOficina, idCasa, idVenta, idDepto, idEstacionamiento, idArriendo, idPerfil);
    }

    @OneToMany(mappedBy = "propiedadByIdPropiedad")
    public Collection<Bodega> getBodegasByIdPropiedad() {
        return bodegasByIdPropiedad;
    }

    public void setBodegasByIdPropiedad(Collection<Bodega> bodegasByIdPropiedad) {
        this.bodegasByIdPropiedad = bodegasByIdPropiedad;
    }

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO", nullable = false)
    public Estado getEstadoByIdEstado() {
        return estadoByIdEstado;
    }

    public void setEstadoByIdEstado(Estado estadoByIdEstado) {
        this.estadoByIdEstado = estadoByIdEstado;
    }

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PROP", referencedColumnName = "ID_TIPO_PROP", nullable = false)
    public TipoPropiedad getTipoPropiedadByIdTipoProp() {
        return tipoPropiedadByIdTipoProp;
    }

    public void setTipoPropiedadByIdTipoProp(TipoPropiedad tipoPropiedadByIdTipoProp) {
        this.tipoPropiedadByIdTipoProp = tipoPropiedadByIdTipoProp;
    }

    @ManyToOne
    @JoinColumn(name = "ID_COMUNA", referencedColumnName = "ID_COMUNA", nullable = false)
    public Comuna getComunaByIdComuna() {
        return comunaByIdComuna;
    }

    public void setComunaByIdComuna(Comuna comunaByIdComuna) {
        this.comunaByIdComuna = comunaByIdComuna;
    }

    @ManyToOne
    @JoinColumn(name = "ID_OFICINA", referencedColumnName = "ID_OFICINA")
    public Oficina getOficinaByIdOficina() {
        return oficinaByIdOficina;
    }

    public void setOficinaByIdOficina(Oficina oficinaByIdOficina) {
        this.oficinaByIdOficina = oficinaByIdOficina;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CASA", referencedColumnName = "ID_CASA")
    public Casa getCasaByIdCasa() {
        return casaByIdCasa;
    }

    public void setCasaByIdCasa(Casa casaByIdCasa) {
        this.casaByIdCasa = casaByIdCasa;
    }

    @ManyToOne
    @JoinColumn(name = "ID_VENTA", referencedColumnName = "ID_VENTA")
    public Venta getVentaByIdVenta() {
        return ventaByIdVenta;
    }

    public void setVentaByIdVenta(Venta ventaByIdVenta) {
        this.ventaByIdVenta = ventaByIdVenta;
    }

    @ManyToOne
    @JoinColumn(name = "ID_DEPTO", referencedColumnName = "ID_DEPTO")
    public Departamento getDepartamentoByIdDepto() {
        return departamentoByIdDepto;
    }

    public void setDepartamentoByIdDepto(Departamento departamentoByIdDepto) {
        this.departamentoByIdDepto = departamentoByIdDepto;
    }

    @ManyToOne
    @JoinColumn(name = "ID_ESTACIONAMIENTO", referencedColumnName = "ID_ESTACIONAMIENTO")
    public Estacionamiento getEstacionamientoByIdEstacionamiento() {
        return estacionamientoByIdEstacionamiento;
    }

    public void setEstacionamientoByIdEstacionamiento(Estacionamiento estacionamientoByIdEstacionamiento) {
        this.estacionamientoByIdEstacionamiento = estacionamientoByIdEstacionamiento;
    }

    @ManyToOne
    @JoinColumn(name = "ID_ARRIENDO", referencedColumnName = "ID_ARRIENDO")
    public Arriendo getArriendoByIdArriendo() {
        return arriendoByIdArriendo;
    }

    public void setArriendoByIdArriendo(Arriendo arriendoByIdArriendo) {
        this.arriendoByIdArriendo = arriendoByIdArriendo;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL", nullable = false)
    public PerfilCliente getPerfilClienteByIdPerfil() {
        return perfilClienteByIdPerfil;
    }

    public void setPerfilClienteByIdPerfil(PerfilCliente perfilClienteByIdPerfil) {
        this.perfilClienteByIdPerfil = perfilClienteByIdPerfil;
    }
}
