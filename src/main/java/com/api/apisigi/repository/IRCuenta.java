package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Cuenta;

import java.io.Serializable;

@Repository("cuentaRepo")
public interface IRCuenta extends JpaRepository<Cuenta, Serializable> {

}
