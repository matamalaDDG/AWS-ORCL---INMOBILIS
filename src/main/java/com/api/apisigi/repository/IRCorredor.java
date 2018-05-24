package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Corredor;

import java.io.Serializable;

@Repository("corredorRepo")
public interface IRCorredor extends JpaRepository<Corredor, Serializable> {
}
