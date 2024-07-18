package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.RecommendLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendLogRepository extends JpaRepository<RecommendLog,Long> {
}
