package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Estacionamiento;

import java.io.Serializable;

@Repository("estacionamientoRepo")
public interface IREstacionamiento extends JpaRepository<Estacionamiento, String> {
}
