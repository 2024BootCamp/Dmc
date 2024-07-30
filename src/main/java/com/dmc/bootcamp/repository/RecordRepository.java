package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record,Long> {

}
