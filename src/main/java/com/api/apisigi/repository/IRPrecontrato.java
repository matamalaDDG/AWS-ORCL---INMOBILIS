package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Precontrato;

import java.io.Serializable;

@Repository("preContratoRepo")
public interface IRPrecontrato extends JpaRepository<Precontrato, String> {
}
