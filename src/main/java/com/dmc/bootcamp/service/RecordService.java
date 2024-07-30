package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Record;
import com.dmc.bootcamp.dto.request.RecordRequest;
import com.dmc.bootcamp.repository.FoodRepository;
import com.dmc.bootcamp.repository.RecordRepository;
import com.dmc.bootcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private  UserRepository userRepository;

    private   FoodRepository foodRepository;


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

    public void deleteRecord(long id) {
        recordRepository.deleteById(id);
    }

}
