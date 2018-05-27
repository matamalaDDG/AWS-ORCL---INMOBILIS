package com.api.apisigi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "BOLETA_HONORARIO", schema = "SIGIADMIN", catalog = "")
public class BoletaHonorario {
    private String idBoleta;
    private String descripcion;
    private Documento documento;
    private Collection<CapacidadEconomica> capacidadeconomica;

    @Id
    @Column(name = "ID_BOLETA")
    public String getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(String idBoleta) {
        this.idBoleta = idBoleta;
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
        BoletaHonorario that = (BoletaHonorario) o;
        return Objects.equals(idBoleta, that.idBoleta) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBoleta, descripcion);
    }

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false)
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    @OneToMany(mappedBy = "boletahonorario")
    public Collection<CapacidadEconomica> getCapacidadeconomica() {
        return capacidadeconomica;
    }

    public void setCapacidadeconomica(Collection<CapacidadEconomica> capacidadeconomica) {
        this.capacidadeconomica = capacidadeconomica;
    }
}
