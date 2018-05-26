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
    private Collection<BoletaHonorario> boletaHonorariosByIdDocumento;
    private Collection<CedulaIdentidad> cedulaIdentidadsByIdDocumento;
    private Collection<Conservador> conservadorsByIdDocumento;
    private Collection<Contrato> contratoesByIdDocumento;
    private Collection<DocBanco> docBancosByIdDocumento;
    private Collection<DocNotaria> docNotariasByIdDocumento;
    private Collection<LiquidacionSueldo> liquidacionSueldosByIdDocumento;
    private Collection<Precontrato> precontratoesByIdDocumento;
    private Collection<Tasacion> tasacionsByIdDocumento;

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

    @OneToMany(mappedBy = "documentoByIdDocumento")
    public Collection<BoletaHonorario> getBoletaHonorariosByIdDocumento() {
        return boletaHonorariosByIdDocumento;
    }

    public void setBoletaHonorariosByIdDocumento(Collection<BoletaHonorario> boletaHonorariosByIdDocumento) {
        this.boletaHonorariosByIdDocumento = boletaHonorariosByIdDocumento;
    }

    @OneToMany(mappedBy = "documentoByIdDocumento")
    public Collection<CedulaIdentidad> getCedulaIdentidadsByIdDocumento() {
        return cedulaIdentidadsByIdDocumento;
    }

    public void setCedulaIdentidadsByIdDocumento(Collection<CedulaIdentidad> cedulaIdentidadsByIdDocumento) {
        this.cedulaIdentidadsByIdDocumento = cedulaIdentidadsByIdDocumento;
    }

    @OneToMany(mappedBy = "documentoByIdDocumento")
    public Collection<Conservador> getConservadorsByIdDocumento() {
        return conservadorsByIdDocumento;
    }

    public void setConservadorsByIdDocumento(Collection<Conservador> conservadorsByIdDocumento) {
        this.conservadorsByIdDocumento = conservadorsByIdDocumento;
    }

    @OneToMany(mappedBy = "documentoByIdDocumento")
    public Collection<Contrato> getContratoesByIdDocumento() {
        return contratoesByIdDocumento;
    }

    public void setContratoesByIdDocumento(Collection<Contrato> contratoesByIdDocumento) {
        this.contratoesByIdDocumento = contratoesByIdDocumento;
    }

    @OneToMany(mappedBy = "documentoByIdDocumento")
    public Collection<DocBanco> getDocBancosByIdDocumento() {
        return docBancosByIdDocumento;
    }

    public void setDocBancosByIdDocumento(Collection<DocBanco> docBancosByIdDocumento) {
        this.docBancosByIdDocumento = docBancosByIdDocumento;
    }

    @OneToMany(mappedBy = "documentoByIdDocumento")
    public Collection<DocNotaria> getDocNotariasByIdDocumento() {
        return docNotariasByIdDocumento;
    }

    public void setDocNotariasByIdDocumento(Collection<DocNotaria> docNotariasByIdDocumento) {
        this.docNotariasByIdDocumento = docNotariasByIdDocumento;
    }

    @OneToMany(mappedBy = "documentoByIdDocumento")
    public Collection<LiquidacionSueldo> getLiquidacionSueldosByIdDocumento() {
        return liquidacionSueldosByIdDocumento;
    }

    public void setLiquidacionSueldosByIdDocumento(Collection<LiquidacionSueldo> liquidacionSueldosByIdDocumento) {
        this.liquidacionSueldosByIdDocumento = liquidacionSueldosByIdDocumento;
    }

    @OneToMany(mappedBy = "documentoByIdDocumento")
    public Collection<Precontrato> getPrecontratoesByIdDocumento() {
        return precontratoesByIdDocumento;
    }

    public void setPrecontratoesByIdDocumento(Collection<Precontrato> precontratoesByIdDocumento) {
        this.precontratoesByIdDocumento = precontratoesByIdDocumento;
    }

    @OneToMany(mappedBy = "documentoByIdDocumento")
    public Collection<Tasacion> getTasacionsByIdDocumento() {
        return tasacionsByIdDocumento;
    }

    public void setTasacionsByIdDocumento(Collection<Tasacion> tasacionsByIdDocumento) {
        this.tasacionsByIdDocumento = tasacionsByIdDocumento;
    }
}
