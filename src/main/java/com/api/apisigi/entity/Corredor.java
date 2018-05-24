package com.api.apisigi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Corredor {
    private String nombreCorredor;
    private String idCorredor;
    private String idPerfil;

    @Basic
    @Column(name = "NOMBRE_CORREDOR")
    public String getNombreCorredor() {
        return nombreCorredor;
    }

    public void setNombreCorredor(String nombreCorredor) {
        this.nombreCorredor = nombreCorredor;
    }

    @Id
    @Column(name = "ID_CORREDOR")
    public String getIdCorredor() {
        return idCorredor;
    }

    public void setIdCorredor(String idCorredor) {
        this.idCorredor = idCorredor;
    }

    @Basic
    @Column(name = "ID_PERFIL")
    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corredor corredor = (Corredor) o;
        return Objects.equals(nombreCorredor, corredor.nombreCorredor) &&
                Objects.equals(idCorredor, corredor.idCorredor) &&
                Objects.equals(idPerfil, corredor.idPerfil);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombreCorredor, idCorredor, idPerfil);
    }
}
