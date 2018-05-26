package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Corredor {
    private String nombreCorredor;
    private String idCorredor;
    private String idPerfil;
    private Collection<Arriendo> arriendosByIdCorredor;
    private PerfilCliente perfilClienteByIdPerfil;
    private Collection<Venta> ventasByIdCorredor;

    @Basic
    @Column(name = "NOMBRE_CORREDOR")
    public String getNombreCorredor() {
        return nombreCorredor;
    }

    public void setNombreCorredor(String nombreCorredor) {
        this.nombreCorredor = nombreCorredor;
    }

    @Id
    @Column(name = "ID_CORREDOR")
    public String getIdCorredor() {
        return idCorredor;
    }

    public void setIdCorredor(String idCorredor) {
        this.idCorredor = idCorredor;
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
        Corredor corredor = (Corredor) o;
        return Objects.equals(nombreCorredor, corredor.nombreCorredor) &&
                Objects.equals(idCorredor, corredor.idCorredor) &&
                Objects.equals(idPerfil, corredor.idPerfil);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombreCorredor, idCorredor, idPerfil);
    }

    @OneToMany(mappedBy = "corredorByIdCorredor")
    public Collection<Arriendo> getArriendosByIdCorredor() {
        return arriendosByIdCorredor;
    }

    public void setArriendosByIdCorredor(Collection<Arriendo> arriendosByIdCorredor) {
        this.arriendosByIdCorredor = arriendosByIdCorredor;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL", nullable = false)
    public PerfilCliente getPerfilClienteByIdPerfil() {
        return perfilClienteByIdPerfil;
    }

    public void setPerfilClienteByIdPerfil(PerfilCliente perfilClienteByIdPerfil) {
        this.perfilClienteByIdPerfil = perfilClienteByIdPerfil;
    }

    @OneToMany(mappedBy = "corredorByIdCorredor")
    public Collection<Venta> getVentasByIdCorredor() {
        return ventasByIdCorredor;
    }

    public void setVentasByIdCorredor(Collection<Venta> ventasByIdCorredor) {
        this.ventasByIdCorredor = ventasByIdCorredor;
    }
}
