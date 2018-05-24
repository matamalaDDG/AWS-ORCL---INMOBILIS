package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Tasacion;

import java.io.Serializable;

@Repository("tasacionRepo")
public interface IRTasacion extends JpaRepository<Tasacion, Serializable> {
}
