package com.api.apisigi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.TipoPropiedad;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

@Repository("tipoPropiedadRepo")
public interface IRTipoPropiedad extends JpaRepository<TipoPropiedad, String> {
}
