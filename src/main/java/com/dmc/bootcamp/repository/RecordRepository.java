package com.dmc.bootcamp.repository;

<<<<<<< HEAD
import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record,Long> {
    List<Record> findRecordByAppUser(AppUser user);
=======
import com.dmc.bootcamp.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record,Long> {
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608

}
