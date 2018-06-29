package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Venta;

import java.io.Serializable;
import java.util.Optional;

@Repository("ventaRepo")
public interface IRVenta extends JpaRepository<Venta, String> {
    public abstract Optional<Venta> findVentaByConservadorAndConvenioAndDocbancoAndDocnotariaAndServiciosAndTasacion(String idconservador,
                                                                                                                                String idcovenio,
                                                                                                                                String iddocbanco,
                                                                                                                                String iddocnotaria,
                                                                                                                                String idservicio,
                                                                                                                                String idtasacion);
}
