package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Record;
import com.dmc.bootcamp.dto.request.RecordRequest;
<<<<<<< HEAD
import com.dmc.bootcamp.repository.RecordRepository;
import com.dmc.bootcamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
=======
import com.dmc.bootcamp.repository.FoodRepository;
import com.dmc.bootcamp.repository.RecordRepository;
import com.dmc.bootcamp.repository.UserRepository;
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
<<<<<<< HEAD
@RequiredArgsConstructor
public class RecordService {

    @Autowired
    private final RecordRepository recordRepository;

    @Autowired
    private final UserRepository userRepository;
=======

public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private  UserRepository userRepository;

    private   FoodRepository foodRepository;
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608


    public Record saveRecord(RecordRequest recordRequest){
        AppUser user= userRepository.findUserByUserId(recordRequest.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return recordRepository.save(recordRequest.toEntity(user));
    }

    @Transactional
    public List<Record> getAllRecords(){
        List<Record> records = recordRepository.findAll();
        records.forEach(record -> {
            if (record.getListMeal() != null) {
                record.getListMeal().size();
            }
        });
        return records;
    }

    @Transactional
    public Record getRecordById(long id) {
        Record record = recordRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Record not found"));
        // Initialize lazy collections if necessary
        if (record.getListMeal() != null) {
            record.getListMeal().size();
        }
        return  record;
    }

<<<<<<< HEAD
    public List<Record> findRecordByUserId(String userId){
        AppUser user= userRepository.findUserByUserId(userId);
        if (user==null){
            throw new IllegalArgumentException("User not found");
        }
        return recordRepository.findRecordByAppUser(user);
    }

=======
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
    public void deleteRecord(long id) {
        recordRepository.deleteById(id);
    }

}
