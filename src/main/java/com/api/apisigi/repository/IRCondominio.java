package com.api.apisigi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Condominio;


@Repository("condominioRepo")
public interface IRCondominio extends JpaRepository<Condominio, String> {
    public abstract Page<Condominio> findByIdCondominio(String id, Pageable pageable);
    public abstract Page<Condominio> findAllB();
}
