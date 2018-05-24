package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Edificio;

import java.io.Serializable;

@Repository("edificioRepo")
public interface IREdificio extends JpaRepository<Edificio, Serializable> {
}
