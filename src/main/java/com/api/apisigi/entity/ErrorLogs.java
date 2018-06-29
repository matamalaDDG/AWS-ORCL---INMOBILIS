package com.api.apisigi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;
//TODO PROCEDIMIENTO ALMACENADO ERRORLOGS
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "UUID")
public class ErrorLogs extends Exception{
    private String idError;
    private String descripcion;

    @Id
    @Column(name = "ID_ERROR")
    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorLogs errorLogs = (ErrorLogs) o;
        return Objects.equals(idError, errorLogs.idError) &&
                Objects.equals(descripcion, errorLogs.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idError, descripcion);
    }
}
