package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.RecommendLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RecommendLogRepository extends JpaRepository<RecommendLog,Long> {
   //추천 로그 날짜 조회를 위한 리포지토리 메서드 추가
   @Query("SELECT r FROM RecommendLog r WHERE DATE(r.recomTime) = :date")
   List<RecommendLog> findByDate(@Param("date") LocalDate date);
}