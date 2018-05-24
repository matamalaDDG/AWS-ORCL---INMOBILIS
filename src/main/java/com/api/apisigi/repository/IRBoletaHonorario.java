package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.apisigi.entity.BoletaHonorario;

import java.io.Serializable;

public interface IRBoletaHonorario extends JpaRepository<BoletaHonorario, Serializable> {
}
