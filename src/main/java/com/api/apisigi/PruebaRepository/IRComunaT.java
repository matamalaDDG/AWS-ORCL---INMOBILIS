package com.api.apisigi.PruebaRepository;

import com.api.apisigi.pruebaEntity.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("comunaTRepo")
public interface IRComunaT  extends JpaRepository<Comuna, Serializable> {
}
