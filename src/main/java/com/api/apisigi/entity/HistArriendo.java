package com.api.apisigi.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "HIST_ARRIENDO", schema = "SIGIADMIN", catalog = "")
public class HistArriendo {
    private String idHistArr;
    private String arrendatario;
    private Time fechaArriendo;
    private String documentos;

    @Id
    @Column(name = "ID_HIST_ARR")
    public String getIdHistArr() {
        return idHistArr;
    }

    public void setIdHistArr(String idHistArr) {
        this.idHistArr = idHistArr;
    }

    @Basic
    @Column(name = "ARRENDATARIO")
    public String getArrendatario() {
        return arrendatario;
    }

    public void setArrendatario(String arrendatario) {
        this.arrendatario = arrendatario;
    }

    @Basic
    @Column(name = "FECHA_ARRIENDO")
    public Time getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Time fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    @Basic
    @Column(name = "DOCUMENTOS")
    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistArriendo that = (HistArriendo) o;
        return Objects.equals(idHistArr, that.idHistArr) &&
                Objects.equals(arrendatario, that.arrendatario) &&
                Objects.equals(fechaArriendo, that.fechaArriendo) &&
                Objects.equals(documentos, that.documentos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idHistArr, arrendatario, fechaArriendo, documentos);
    }
}
