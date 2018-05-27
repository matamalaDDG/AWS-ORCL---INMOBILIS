package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.CapacidadEconomica;

import java.io.Serializable;

@Repository("capacidadEconomicaRepo")
public interface IRCapacidadEconomica extends JpaRepository<CapacidadEconomica, Serializable> {
}
