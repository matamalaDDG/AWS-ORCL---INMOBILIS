package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.DocBanco;

import java.io.Serializable;

@Repository("docbancoRepo")
public interface IRDocBanco extends JpaRepository<DocBanco, String> {
}
