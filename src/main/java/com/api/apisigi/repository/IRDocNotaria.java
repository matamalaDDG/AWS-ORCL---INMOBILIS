package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.DocNotaria;

import java.io.Serializable;

@Repository("docNotariaRepo")
public interface IRDocNotaria extends JpaRepository<DocNotaria, String> {
}
