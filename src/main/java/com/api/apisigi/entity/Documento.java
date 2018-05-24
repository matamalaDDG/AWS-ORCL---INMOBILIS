package com.api.apisigi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Documento {
    private String idDocumento;
    private String descripcion;
    private byte[] documento;

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
}
