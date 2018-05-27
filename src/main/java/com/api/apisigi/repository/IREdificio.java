package com.api.apisigi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Edificio;

import java.io.Serializable;

@Repository("edificioRepo")
public interface IREdificio extends JpaRepository<Edificio, String> {
    public abstract Page<Edificio> findByIdEdificio(String id,Pageable pageable);

}
