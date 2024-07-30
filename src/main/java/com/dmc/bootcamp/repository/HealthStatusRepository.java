package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.HealthStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthStatusRepository extends JpaRepository<HealthStatus,Long> {
}
