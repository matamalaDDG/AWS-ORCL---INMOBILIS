package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO CORREDOR
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class Corredor {
    private String nombreCorredor;
    private String idCorredor;
    private Collection<Arriendo> arriendo;
    private PerfilCliente perfilcliente;
    private Collection<Venta> venta;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corredor corredor = (Corredor) o;
        return Objects.equals(nombreCorredor, corredor.nombreCorredor) &&
                Objects.equals(idCorredor, corredor.idCorredor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombreCorredor, idCorredor);
    }

    @OneToMany(mappedBy = "corredor")
    public Collection<Arriendo> getArriendo() {
        return arriendo;
    }

    public void setArriendo(Collection<Arriendo> arriendo) {
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

    @OneToMany(mappedBy = "corredor")
    public Collection<Venta> getVenta() {
        return venta;
    }

    public void setVenta(Collection<Venta> venta) {
        this.venta = venta;
    }
}
