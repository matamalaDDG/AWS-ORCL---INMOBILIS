package com.api.apisigi.model;

import com.api.apisigi.entity.ErrorLogs;

import java.util.Objects;

public class MErrorLogs {
    private String idError;
    private String descripcion;

    public MErrorLogs() {
    }

    public MErrorLogs(ErrorLogs errorLogs) {
        this.idError = errorLogs.getIdError();
        this.descripcion = errorLogs.getDescripcion();
    }

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MErrorLogs)) return false;
        MErrorLogs that = (MErrorLogs) o;
        return Objects.equals(getIdError(), that.getIdError()) &&
                Objects.equals(getDescripcion(), that.getDescripcion());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdError(), getDescripcion());
    }

    @Override
    public String toString() {
        return "MErrorLogs{" +
                "idError='" + idError + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
