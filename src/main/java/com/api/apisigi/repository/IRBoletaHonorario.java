package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.apisigi.entity.BoletaHonorario;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository("boletahonorarioRepo")
public interface IRBoletaHonorario extends JpaRepository<BoletaHonorario, String> {
}
