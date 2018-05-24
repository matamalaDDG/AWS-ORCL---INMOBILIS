package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Venta;

import java.io.Serializable;

@Repository("ventaRepo")
public interface IRVenta extends JpaRepository<Venta, Serializable> {
}
