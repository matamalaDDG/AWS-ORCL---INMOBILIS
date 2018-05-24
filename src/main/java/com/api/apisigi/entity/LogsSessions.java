package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LOGS_SESSIONS", schema = "SIGIADMIN", catalog = "")
public class LogsSessions {
    private String idLogSession;
    private String descripcion;

    @Id
    @Column(name = "ID_LOG_SESSION")
    public String getIdLogSession() {
        return idLogSession;
    }

    public void setIdLogSession(String idLogSession) {
        this.idLogSession = idLogSession;
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
        LogsSessions that = (LogsSessions) o;
        return Objects.equals(idLogSession, that.idLogSession) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLogSession, descripcion);
    }
}
