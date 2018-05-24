package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.PatenteComercial;

import java.io.Serializable;

@Repository("patenteComercialRepo")
public interface IRPatenteComercial extends JpaRepository<PatenteComercial, Serializable> {
}
