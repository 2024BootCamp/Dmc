package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record,Long> {
    List<Record> findRecordByAppUser(AppUser user);

    @Query(value = "SELECT * FROM record WHERE user_id = :userId", nativeQuery = true)
    List<Record> findRecordsByUserId(@Param("userId") String userId);



}
