package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Arriendo;
import com.api.apisigi.model.MArriendo;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

@Repository("arriendoRepo")
public interface IRArriendo extends JpaRepository<Arriendo, Serializable> {

    public abstract Arriendo findByMonto(String nombre);

    public abstract List<Arriendo> findByFechaArriendoAndMontoOrderByFechaArriendo(Time fechaArriendo, int monto);


}
