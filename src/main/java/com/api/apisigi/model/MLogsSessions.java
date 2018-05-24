package com.api.apisigi.model;

import com.api.apisigi.entity.LogsSessions;

import java.util.Objects;

public class MLogsSessions {

    private String idLogSession;
    private String descripcion;

    public MLogsSessions() {
    }

    public MLogsSessions(LogsSessions logsSessions) {
        this.idLogSession = logsSessions.getIdLogSession();
        this.descripcion = logsSessions.getDescripcion();
    }

    public String getIdLogSession() {
        return idLogSession;
    }

    public void setIdLogSession(String idLogSession) {
        this.idLogSession = idLogSession;
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
        if (!(o instanceof MLogsSessions)) return false;
        MLogsSessions that = (MLogsSessions) o;
        return Objects.equals(getIdLogSession(), that.getIdLogSession()) &&
                Objects.equals(getDescripcion(), that.getDescripcion());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdLogSession(), getDescripcion());
    }

    @Override
    public String toString() {
        return "MLogsSessions{" +
                "idLogSession='" + idLogSession + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
