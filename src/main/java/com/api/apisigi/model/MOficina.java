package com.api.apisigi.model;

import com.api.apisigi.entity.Oficina;

import java.util.Objects;

public class MOficina {

    private String idOficina;
    private long numOficina;
    private long mtsCuadDisp;
    private String idPatente;

    public MOficina() {
    }

    public MOficina(Oficina oficina) {
        this.idOficina = oficina.getIdOficina();
        this.numOficina = oficina.getNumOficina();
        this.mtsCuadDisp = oficina.getMtsCuadDisp();
        this.idPatente = oficina.getIdPatente();
    }

    public String getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(String idOficina) {
        this.idOficina = idOficina;
    }

    public long getNumOficina() {
        return numOficina;
    }

    public void setNumOficina(long numOficina) {
        this.numOficina = numOficina;
    }

    public long getMtsCuadDisp() {
        return mtsCuadDisp;
    }

    public void setMtsCuadDisp(long mtsCuadDisp) {
        this.mtsCuadDisp = mtsCuadDisp;
    }

    public String getIdPatente() {
        return idPatente;
    }

    public void setIdPatente(String idPatente) {
        this.idPatente = idPatente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MOficina)) return false;
        MOficina mOficina = (MOficina) o;
        return getNumOficina() == mOficina.getNumOficina() &&
                getMtsCuadDisp() == mOficina.getMtsCuadDisp() &&
                Objects.equals(getIdOficina(), mOficina.getIdOficina()) &&
                Objects.equals(getIdPatente(), mOficina.getIdPatente());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdOficina(), getNumOficina(), getMtsCuadDisp(), getIdPatente());
    }

    @Override
    public String toString() {
        return "MOficina{" +
                "idOficina='" + idOficina + '\'' +
                ", numOficina=" + numOficina +
                ", mtsCuadDisp=" + mtsCuadDisp +
                ", idPatente='" + idPatente + '\'' +
                '}';
    }
}
