package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Servicios;

import java.io.Serializable;

@Repository("servicioRepo")
public interface IRServicios extends JpaRepository<Servicios, String> {
}
