package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.HealthStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HealthStatusRepository extends JpaRepository<HealthStatus,Long> {

    //유저 Id에 따라 건강 관리 기록를 조회
    @Query(value = "select * from health_status where user_id = :userId",nativeQuery = true)
    List<HealthStatus> findHealthStatusByUserId(@Param("userId") String userId);


}
