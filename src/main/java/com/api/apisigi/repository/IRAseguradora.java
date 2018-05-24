package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Aseguradora;

import java.io.Serializable;

@Repository("aseguradoraRepo")
public interface IRAseguradora extends JpaRepository<Aseguradora, Serializable> {
}
