package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Condominio;

import java.io.Serializable;

@Repository("condominioRepo")
public interface IRCondominio extends JpaRepository<Condominio, Serializable> {
}
