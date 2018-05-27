package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.LogsSessions;

import java.io.Serializable;

@Repository("logsSessionsRepo")
public interface IRLogsSessions extends JpaRepository<LogsSessions, String> {
}
