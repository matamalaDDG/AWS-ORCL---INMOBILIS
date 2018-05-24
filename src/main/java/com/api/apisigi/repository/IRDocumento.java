package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Documento;

import java.io.Serializable;

@Repository("documentoRepo")
public interface IRDocumento extends JpaRepository<Documento, Serializable> {
}
