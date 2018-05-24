package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Bodega;

import java.io.Serializable;

@Repository("bodegaRepo")
public interface IRBodega extends JpaRepository<Bodega, Serializable> {
}
