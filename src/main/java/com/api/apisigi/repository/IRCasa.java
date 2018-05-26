package com.api.apisigi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Casa;

import java.io.Serializable;
import java.util.List;

@Repository("casaRepo")
public interface IRCasa extends JpaRepository<Casa, String> {
    public abstract Page<Casa> findByCondominio(String condominioId, Pageable pageable);
    public abstract Page<Casa> findByIdCasa(String idCasa,Pageable pageable);
    public abstract Page<Casa> findAllByIdCasa(String idCasa,Pageable pageable);
    public abstract List<Casa> findAll();
}
