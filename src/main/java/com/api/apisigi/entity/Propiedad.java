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
    private Bodega bodega;
    //private Collection<Bodega> bodega;
    private Estado estado;
    private TipoPropiedad tipopropiedad;
    private Comuna comuna;
    private Oficina oficina;
    private Casa casa;
    private Venta venta;
    private Departamento departamento;
    private Estacionamiento estacionamiento;
    private Arriendo arriendo;
    private PerfilCliente perfilcliente;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propiedad propiedad = (Propiedad) o;
        return Objects.equals(idPropiedad, propiedad.idPropiedad) &&
                Objects.equals(direccion, propiedad.direccion) &&
                Objects.equals(tipoDueno, propiedad.tipoDueno) &&
                Objects.equals(disponibilidad, propiedad.disponibilidad);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPropiedad, direccion, tipoDueno, disponibilidad);
    }

   /* @OneToMany(mappedBy = "bodega")
    public Collection<Bodega> getBodega() {
        return bodega;
    }**/
    @ManyToOne
     @JoinColumn(name ="ID_BODEGA", referencedColumnName = "ID_BODEGA", nullable = false)
    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

   /* public void setBodega(Collection<Bodega> bodega) {
        this.bodega = bodega;
    }*/

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO", nullable = false)
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PROP", referencedColumnName = "ID_TIPO_PROP", nullable = false)
    public TipoPropiedad getTipopropiedad() {
        return tipopropiedad;
    }

    public void setTipopropiedad(TipoPropiedad tipopropiedad) {
        this.tipopropiedad = tipopropiedad;
    }

    @ManyToOne
    @JoinColumn(name = "ID_COMUNA", referencedColumnName = "ID_COMUNA", nullable = false)
    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    @ManyToOne
    @JoinColumn(name = "ID_OFICINA", referencedColumnName = "ID_OFICINA")
    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CASA", referencedColumnName = "ID_CASA")
    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    @ManyToOne
    @JoinColumn(name = "ID_VENTA", referencedColumnName = "ID_VENTA")
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @ManyToOne
    @JoinColumn(name = "ID_DEPTO", referencedColumnName = "ID_DEPTO")
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @ManyToOne
    @JoinColumn(name = "ID_ESTACIONAMIENTO", referencedColumnName = "ID_ESTACIONAMIENTO")
    public Estacionamiento getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(Estacionamiento estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    @ManyToOne
    @JoinColumn(name = "ID_ARRIENDO", referencedColumnName = "ID_ARRIENDO")
    public Arriendo getArriendo() {
        return arriendo;
    }

    public void setArriendo(Arriendo arriendo) {
        this.arriendo = arriendo;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL", nullable = false)
    public PerfilCliente getPerfilcliente() {
        return perfilcliente;
    }

    public void setPerfilcliente(PerfilCliente perfilcliente) {
        this.perfilcliente = perfilcliente;
    }
}
