package com.api.apisigi.model;

import com.api.apisigi.entity.Departamento;

import java.util.Objects;

public class MDepartamento {
    private String idDepto;
    private String idEdificio;
    private long cantDorm;
    private long numDepto;
    private long cantBaños;
    private long mtsCuadConst;

    public MDepartamento() {
    }

    public MDepartamento(Departamento departamento) {
        this.idDepto = departamento.getIdDepto();
        this.idEdificio = departamento.getIdEdificio();
        this.cantDorm = departamento.getCantDorm();
        this.numDepto = departamento.getNumDepto();
        this.cantBaños = departamento.getCantBaños();
        this.mtsCuadConst = departamento.getMtsCuadConst();
    }

    public String getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(String idDepto) {
        this.idDepto = idDepto;
    }

    public String getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(String idEdificio) {
        this.idEdificio = idEdificio;
    }

    public long getCantDorm() {
        return cantDorm;
    }

    public void setCantDorm(long cantDorm) {
        this.cantDorm = cantDorm;
    }

    public long getNumDepto() {
        return numDepto;
    }

    public void setNumDepto(long numDepto) {
        this.numDepto = numDepto;
    }

    public long getCantBaños() {
        return cantBaños;
    }

    public void setCantBaños(long cantBaños) {
        this.cantBaños = cantBaños;
    }

    public long getMtsCuadConst() {
        return mtsCuadConst;
    }

    public void setMtsCuadConst(long mtsCuadConst) {
        this.mtsCuadConst = mtsCuadConst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MDepartamento)) return false;
        MDepartamento that = (MDepartamento) o;
        return getCantDorm() == that.getCantDorm() &&
                getNumDepto() == that.getNumDepto() &&
                getCantBaños() == that.getCantBaños() &&
                getMtsCuadConst() == that.getMtsCuadConst() &&
                Objects.equals(getIdDepto(), that.getIdDepto()) &&
                Objects.equals(getIdEdificio(), that.getIdEdificio());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdDepto(), getIdEdificio(), getCantDorm(), getNumDepto(), getCantBaños(), getMtsCuadConst());
    }

    @Override
    public String toString() {
        return "MDepartamento{" +
                "idDepto='" + idDepto + '\'' +
                ", idEdificio='" + idEdificio + '\'' +
                ", cantDorm=" + cantDorm +
                ", numDepto=" + numDepto +
                ", cantBaños=" + cantBaños +
                ", mtsCuadConst=" + mtsCuadConst +
                '}';
    }
}
