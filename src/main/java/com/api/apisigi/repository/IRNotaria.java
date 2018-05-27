package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Notaria;

import java.io.Serializable;

@Repository("notariaRepo")
public interface IRNotaria extends JpaRepository<Notaria, String> {
}
