package com.api.apisigi.model;

import com.api.apisigi.entity.HistArriendo;

import java.sql.Time;
import java.util.Arrays;
import java.util.Objects;

public class MHistArriendo {

    private String idHistArr;
    private String arrendatario;
    private Time fechaArriendo;
    private String documentos;

    public MHistArriendo() {
    }

    public MHistArriendo(HistArriendo histArriendo) {
        this.idHistArr = histArriendo.getIdHistArr();
        this.arrendatario = histArriendo.getArrendatario();
        this.fechaArriendo = histArriendo.getFechaArriendo();
        this.documentos = histArriendo.getDocumentos();
    }

    public String getIdHistArr() {
        return idHistArr;
    }

    public void setIdHistArr(String idHistArr) {
        this.idHistArr = idHistArr;
    }

    public String getArrendatario() {
        return arrendatario;
    }

    public void setArrendatario(String arrendatario) {
        this.arrendatario = arrendatario;
    }

    public Time getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Time fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

}
