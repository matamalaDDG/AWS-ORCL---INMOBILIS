package com.api.apisigi.PruebaRepository;

import com.api.apisigi.pruebaEntity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository("regionTRepo")
public interface IRRegionT extends JpaRepository<Region, Serializable> {
}
