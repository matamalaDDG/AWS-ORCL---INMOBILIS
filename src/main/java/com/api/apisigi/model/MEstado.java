package com.api.apisigi.model;

import com.api.apisigi.entity.Estado;

import java.util.Objects;

public class MEstado {
    private String idEstado;
    private String estado;

    public MEstado() {
    }

    public MEstado(Estado estado) {
        this.idEstado = estado.getIdEstado();
        this.estado = estado.getEstado();
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MEstado)) return false;
        MEstado mEstado = (MEstado) o;
        return Objects.equals(getIdEstado(), mEstado.getIdEstado()) &&
                Objects.equals(getEstado(), mEstado.getEstado());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdEstado(), getEstado());
    }

    @Override
    public String toString() {
        return "MEstado{" +
                "idEstado='" + idEstado + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
