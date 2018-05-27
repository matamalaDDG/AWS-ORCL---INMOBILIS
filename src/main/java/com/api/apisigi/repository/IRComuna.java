package com.api.apisigi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Comuna;


@Repository("comunaRepo")
public interface IRComuna extends JpaRepository<Comuna, String> {
}
