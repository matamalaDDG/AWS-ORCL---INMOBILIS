package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.TipoPropiedad;

import java.io.Serializable;

@Repository("tipoPropiedadRepo")
public interface IRTipoPropiedad extends JpaRepository<TipoPropiedad, Serializable> {
}
