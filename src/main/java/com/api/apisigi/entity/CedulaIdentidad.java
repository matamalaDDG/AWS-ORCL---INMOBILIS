package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CEDULA_IDENTIDAD", schema = "SIGIADMIN", catalog = "")
public class CedulaIdentidad {
    private String idCedula;
    private String descripcion;
    private String idDocumento;

    @Id
    @Column(name = "ID_CEDULA")
    public String getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(String idCedula) {
        this.idCedula = idCedula;
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
    @Column(name = "ID_DOCUMENTO")
    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CedulaIdentidad that = (CedulaIdentidad) o;
        return Objects.equals(idCedula, that.idCedula) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(idDocumento, that.idDocumento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCedula, descripcion, idDocumento);
    }
}
