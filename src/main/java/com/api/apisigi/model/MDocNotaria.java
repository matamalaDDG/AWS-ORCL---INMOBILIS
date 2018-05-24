package com.api.apisigi.model;

import com.api.apisigi.entity.DocNotaria;

import java.util.Objects;

public class MDocNotaria {
    private String idDocNotaria;
    private String nomNotario;
    private String descripcion;
    private String documento;
    private String idDocumento;

    public MDocNotaria() {
    }

    public MDocNotaria(DocNotaria docnotaria) {
        this.idDocNotaria = docnotaria.getIdDocNotaria();
        this.nomNotario = docnotaria.getNomNotario();
        this.descripcion = docnotaria.getDescripcion();
        this.documento = docnotaria.getDocumento();
        this.idDocumento = docnotaria.getIdDocumento();
    }

    public String getIdDocNotaria() {

        return idDocNotaria;
    }

    public void setIdDocNotaria(String idDocNotaria) {
        this.idDocNotaria = idDocNotaria;
    }

    public String getNomNotario() {
        return nomNotario;
    }

    public void setNomNotario(String nomNotario) {
        this.nomNotario = nomNotario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MDocNotaria)) return false;
        MDocNotaria that = (MDocNotaria) o;
        return Objects.equals(getIdDocNotaria(), that.getIdDocNotaria()) &&
                Objects.equals(getNomNotario(), that.getNomNotario()) &&
                Objects.equals(getDescripcion(), that.getDescripcion()) &&
                Objects.equals(getDocumento(), that.getDocumento()) &&
                Objects.equals(getIdDocumento(), that.getIdDocumento());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdDocNotaria(), getNomNotario(), getDescripcion(), getDocumento(), getIdDocumento());
    }

    @Override
    public String toString() {
        return "MDocNotaria{" +
                "idDocNotaria='" + idDocNotaria + '\'' +
                ", nomNotario='" + nomNotario + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", documento='" + documento + '\'' +
                ", idDocumento='" + idDocumento + '\'' +
                '}';
    }
}
