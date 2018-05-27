package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PATENTE_COMERCIAL", schema = "SIGIADMIN", catalog = "")
public class PatenteComercial {
    private String idPatente;
    private String tipoPatente;
    private Collection<Oficina> oficina;

    @Id
    @Column(name = "ID_PATENTE")
    public String getIdPatente() {
        return idPatente;
    }

    public void setIdPatente(String idPatente) {
        this.idPatente = idPatente;
    }

    @Basic
    @Column(name = "TIPO_PATENTE")
    public String getTipoPatente() {
        return tipoPatente;
    }

    public void setTipoPatente(String tipoPatente) {
        this.tipoPatente = tipoPatente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatenteComercial that = (PatenteComercial) o;
        return Objects.equals(idPatente, that.idPatente) &&
                Objects.equals(tipoPatente, that.tipoPatente);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPatente, tipoPatente);
    }

    @OneToMany(mappedBy = "patenteComercial")
    public Collection<Oficina> getOficina() {
        return oficina;
    }

    public void setOficina(Collection<Oficina> oficina) {
        this.oficina = oficina;
    }
}
