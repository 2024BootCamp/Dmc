package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record,Long> {

}
