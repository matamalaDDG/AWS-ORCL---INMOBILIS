package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Propiedad;

import java.io.Serializable;

@Repository("propiedadRepo")
public interface IRPropiedad extends JpaRepository<Propiedad, Serializable> {
}
