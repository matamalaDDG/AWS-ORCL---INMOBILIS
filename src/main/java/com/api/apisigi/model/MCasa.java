package com.api.apisigi.model;

import com.api.apisigi.entity.Casa;

import java.util.Objects;

public class MCasa {

    private String idCasa;
    private String idCondominio;
    private long cantDorm;
    private long cantBanos;
    private long mtsHabConst;
    private long mtsPatConst;

    public MCasa() {
    }

    public MCasa(Casa casa) {
        this.idCasa = casa.getIdCasa();
        this.idCondominio = casa.getIdCondominio();
        this.cantDorm = casa.getCantDorm();
        this.cantBanos = casa.getCantBanos();
        this.mtsHabConst = casa.getMtsHabConst();
        this.mtsPatConst = casa.getMtsPatConst();
    }


    public String getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(String idCasa) {
        this.idCasa = idCasa;
    }

    public String getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(String idCondominio) {
        this.idCondominio = idCondominio;
    }

    public long getCantDorm() {
        return cantDorm;
    }

    public void setCantDorm(long cantDorm) {
        this.cantDorm = cantDorm;
    }

    public long getCantBanos() {
        return cantBanos;
    }

    public void setCantBanos(long cantBanos) {
        this.cantBanos = cantBanos;
    }

    public long getMtsHabConst() {
        return mtsHabConst;
    }

    public void setMtsHabConst(long mtsHabConst) {
        this.mtsHabConst = mtsHabConst;
    }

    public long getMtsPatConst() {
        return mtsPatConst;
    }

    public void setMtsPatConst(long mtsPatConst) {
        this.mtsPatConst = mtsPatConst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MCasa)) return false;
        MCasa mCasa = (MCasa) o;
        return getCantDorm() == mCasa.getCantDorm() &&
                getCantBanos() == mCasa.getCantBanos() &&
                getMtsHabConst() == mCasa.getMtsHabConst() &&
                getMtsPatConst() == mCasa.getMtsPatConst() &&
                Objects.equals(getIdCasa(), mCasa.getIdCasa()) &&
                Objects.equals(getIdCondominio(), mCasa.getIdCondominio());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdCasa(), getIdCondominio(), getCantDorm(), getCantBanos(), getMtsHabConst(), getMtsPatConst());
    }

    @Override
    public String toString() {
        return "MCasa{" +
                "idCasa='" + idCasa + '\'' +
                ", idCondominio='" + idCondominio + '\'' +
                ", cantDorm=" + cantDorm +
                ", cantBanos=" + cantBanos +
                ", mtsHabConst=" + mtsHabConst +
                ", mtsPatConst=" + mtsPatConst +
                '}';
    }
}
