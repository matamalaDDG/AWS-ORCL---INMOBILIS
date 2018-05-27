package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.ErrorLogs;

import java.io.Serializable;

@Repository("errorLogsRepo")
public interface IRErrorLogs extends JpaRepository<ErrorLogs, String> {
}
