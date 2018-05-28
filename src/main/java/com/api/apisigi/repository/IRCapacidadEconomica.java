package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.CapacidadEconomica;

import java.io.Serializable;
import java.util.Optional;

@Repository("capacidadEconomicaRepo")
public interface IRCapacidadEconomica extends JpaRepository<CapacidadEconomica, String> {
    public abstract Optional<CapacidadEconomica> findCapacidadEconomicaByBoletahonorarioAndAndCedulaidentidadAndContratoAndLiquidacionsueldo(String boletaid,String horarioid,String contratoid,String liquidid);
}
