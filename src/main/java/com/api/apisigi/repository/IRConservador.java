package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Conservador;

import java.io.Serializable;

@Repository("conservadorRepo")
public interface IRConservador extends JpaRepository<Conservador, Serializable> {
}
