package com.api.apisigi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Departamento;

import java.awt.print.Pageable;
import java.io.Serializable;

@Repository("departamentoRepo")
public interface IRDepartamento extends JpaRepository<Departamento, String> {
    public abstract Page<Departamento> findByIdEdificio(String id, Pageable pageable);

}
