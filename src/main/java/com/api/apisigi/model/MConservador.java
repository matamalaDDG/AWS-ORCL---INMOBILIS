package com.api.apisigi.model;

import com.api.apisigi.entity.Conservador;


import java.util.Objects;

public class MConservador {

    private String idDocConservador;
    private String nomConservador;
    private String documento;
    private String idDocumento;

    public MConservador() {
    }

    public MConservador(Conservador conservador) {
        this.idDocConservador = conservador.getIdDocConservador();
        this.nomConservador = conservador.getNomConservador();
        this.documento = conservador.getDocumento();
        this.idDocumento = conservador.getIdDocumento();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MConservador)) return false;
        MConservador that = (MConservador) o;
        return Objects.equals(idDocConservador, that.idDocConservador) &&
                Objects.equals(nomConservador, that.nomConservador) &&
                Objects.equals(documento, that.documento) &&
                Objects.equals(idDocumento, that.idDocumento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDocConservador, nomConservador, documento, idDocumento);
    }

    @Override
    public String toString() {
        return "MConservador{" +
                "idDocConservador='" + idDocConservador + '\'' +
                ", nomConservador='" + nomConservador + '\'' +
                ", documento='" + documento + '\'' +
                ", idDocumento='" + idDocumento + '\'' +
                '}';
    }
}
