package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.HistVentas;

import java.io.Serializable;

@Repository("histVentasRepo")
public interface IRHistVentas extends JpaRepository<HistVentas, Serializable> {
}
