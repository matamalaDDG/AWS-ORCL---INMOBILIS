package com.api.apisigi.model;

import com.api.apisigi.entity.Documento;

import java.util.Arrays;
import java.util.Objects;

public class MDocumento {
    private String idDocumento;
    private String descripcion;
    private byte[] documento;


    public MDocumento() {
    }

    public MDocumento(Documento documento) {
        this.idDocumento = documento.getIdDocumento();
        this.descripcion = documento.getDescripcion();
        this.documento = documento.getDocumento();
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MDocumento)) return false;
        MDocumento that = (MDocumento) o;
        return Objects.equals(getIdDocumento(), that.getIdDocumento()) &&
                Objects.equals(getDescripcion(), that.getDescripcion()) &&
                Arrays.equals(getDocumento(), that.getDocumento());
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(getIdDocumento(), getDescripcion());
        result = 31 * result + Arrays.hashCode(getDocumento());
        return result;
    }

    @Override
    public String toString() {
        return "MDocumento{" +
                "idDocumento='" + idDocumento + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", documento=" + Arrays.toString(documento) +
                '}';
    }
}
