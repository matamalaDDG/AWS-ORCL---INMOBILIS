package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Arriendo;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

@Repository("arriendoRepo")
public interface IRArriendo extends JpaRepository<Arriendo, Serializable> {


}
