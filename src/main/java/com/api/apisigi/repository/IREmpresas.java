package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Empresas;

import java.io.Serializable;

@Repository("empresasRepo")
public interface IREmpresas extends JpaRepository<Empresas, String> {
}
