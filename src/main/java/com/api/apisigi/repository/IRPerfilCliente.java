package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.PerfilCliente;

import java.io.Serializable;

@Repository("perfilClienteRepo")
public interface IRPerfilCliente extends JpaRepository<PerfilCliente, Serializable> {

}
