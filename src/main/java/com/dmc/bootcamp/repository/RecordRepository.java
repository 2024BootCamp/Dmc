package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record,Long> {
    List<Record> findRecordByAppUser(AppUser user);
}
