package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Convenio;

import java.io.Serializable;

@Repository("convenioRepo")
public interface IRConvenio extends JpaRepository<Convenio, String> {
}
