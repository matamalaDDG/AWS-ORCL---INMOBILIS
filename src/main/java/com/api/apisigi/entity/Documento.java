package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Documento {
    private String idDocumento;
    private String descripcion;
    private byte[] documento;
    private Collection<BoletaHonorario> boletahonorario;
    private Collection<CedulaIdentidad> cedulaidentidad;
    private Collection<Conservador> conservador;
    private Collection<Contrato> contrato;
    private Collection<DocBanco> docbanco;
    private Collection<DocNotaria> docnotaria;
    private Collection<LiquidacionSueldo> liquidacionsueldo;
    private Collection<Precontrato> precontrato;
    private Collection<Tasacion> tasacion;

    @Id
    @Column(name = "ID_DOCUMENTO")
    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "DOCUMENTO")
    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento1 = (Documento) o;
        return Objects.equals(idDocumento, documento1.idDocumento) &&
                Objects.equals(descripcion, documento1.descripcion) &&
                Arrays.equals(documento, documento1.documento);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(idDocumento, descripcion);
        result = 31 * result + Arrays.hashCode(documento);
        return result;
    }

    @OneToMany(mappedBy = "documento")
    public Collection<BoletaHonorario> getBoletahonorario() {
        return boletahonorario;
    }

    public void setBoletahonorario(Collection<BoletaHonorario> boletahonorario) {
        this.boletahonorario = boletahonorario;
    }

    @OneToMany(mappedBy = "documento")
    public Collection<CedulaIdentidad> getCedulaidentidad() {
        return cedulaidentidad;
    }

    public void setCedulaidentidad(Collection<CedulaIdentidad> cedulaidentidad) {
        this.cedulaidentidad = cedulaidentidad;
    }

    @OneToMany(mappedBy = "documento")
    public Collection<Conservador> getConservador() {
        return conservador;
    }

    public void setConservador(Collection<Conservador> conservador) {
        this.conservador = conservador;
    }

    @OneToMany(mappedBy = "tbldocumento")
    public Collection<Contrato> getContrato() {
        return contrato;
    }

    public void setContrato(Collection<Contrato> contrato) {
        this.contrato = contrato;
    }

    @OneToMany(mappedBy = "documento")
    public Collection<DocBanco> getDocbanco() {
        return docbanco;
    }

    public void setDocbanco(Collection<DocBanco> docbanco) {
        this.docbanco = docbanco;
    }

    @OneToMany(mappedBy = "documento")
    public Collection<DocNotaria> getDocnotaria() {
        return docnotaria;
    }

    public void setDocnotaria(Collection<DocNotaria> docnotaria) {
        this.docnotaria = docnotaria;
    }

    @OneToMany(mappedBy = "documento")
    public Collection<LiquidacionSueldo> getLiquidacionsueldo() {
        return liquidacionsueldo;
    }

    public void setLiquidacionsueldo(Collection<LiquidacionSueldo> liquidacionsueldo) {
        this.liquidacionsueldo = liquidacionsueldo;
    }

    @OneToMany(mappedBy = "documento")
    public Collection<Precontrato> getPrecontrato() {
        return precontrato;
    }

    public void setPrecontrato(Collection<Precontrato> precontrato) {
        this.precontrato = precontrato;
    }

    @OneToMany(mappedBy = "documento")
    public Collection<Tasacion> getTasacion() {
        return tasacion;
    }

    public void setTasacion(Collection<Tasacion> tasacion) {
        this.tasacion = tasacion;
    }
}
