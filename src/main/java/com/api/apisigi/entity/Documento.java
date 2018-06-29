package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO DOCUMENTO
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class Documento {
    private String idDocumento;
    private String descripcion;
    private byte[] documento;
    private List<BoletaHonorario> boletahonorario;
    private List<CedulaIdentidad> cedulaidentidad;
    private List<Conservador> conservador;
    private List<Contrato> contrato;
    private List<DocBanco> docbanco;
    private List<DocNotaria> docnotaria;
    private List<LiquidacionSueldo> liquidacionsueldo;
    private List<Precontrato> precontrato;
    private List<Tasacion> tasacion;

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
    public List<BoletaHonorario> getBoletahonorario() {
        return boletahonorario;
    }

    public void setBoletahonorario(List<BoletaHonorario> boletahonorario) {
        this.boletahonorario = boletahonorario;
    }

    @OneToMany(mappedBy = "documento")
    public List<CedulaIdentidad> getCedulaidentidad() {
        return cedulaidentidad;
    }

    public void setCedulaidentidad(List<CedulaIdentidad> cedulaidentidad) {
        this.cedulaidentidad = cedulaidentidad;
    }

    @OneToMany(mappedBy = "documento")
    public List<Conservador> getConservador() {
        return conservador;
    }

    public void setConservador(List<Conservador> conservador) {
        this.conservador = conservador;
    }

    @OneToMany(mappedBy = "tbldocumento")
    public List<Contrato> getContrato() {
        return contrato;
    }

    public void setContrato(List<Contrato> contrato) {
        this.contrato = contrato;
    }

    @OneToMany(mappedBy = "documento")
    public List<DocBanco> getDocbanco() {
        return docbanco;
    }

    public void setDocbanco(List<DocBanco> docbanco) {
        this.docbanco = docbanco;
    }

    @OneToMany(mappedBy = "documento")
    public List<DocNotaria> getDocnotaria() {
        return docnotaria;
    }

    public void setDocnotaria(List<DocNotaria> docnotaria) {
        this.docnotaria = docnotaria;
    }

    @OneToMany(mappedBy = "documento")
    public List<LiquidacionSueldo> getLiquidacionsueldo() {
        return liquidacionsueldo;
    }

    public void setLiquidacionsueldo(List<LiquidacionSueldo> liquidacionsueldo) {
        this.liquidacionsueldo = liquidacionsueldo;
    }

    @OneToMany(mappedBy = "documento")
    public List<Precontrato> getPrecontrato() {
        return precontrato;
    }

    public void setPrecontrato(List<Precontrato> precontrato) {
        this.precontrato = precontrato;
    }

    @OneToMany(mappedBy = "documento")
    public List<Tasacion> getTasacion() {
        return tasacion;
    }

    public void setTasacion(List<Tasacion> tasacion) {
        this.tasacion = tasacion;
    }
}
