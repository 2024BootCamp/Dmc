package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Record;
import com.dmc.bootcamp.dto.request.RecordRequest;
import com.dmc.bootcamp.dto.request.UpdateRecordRequest;
import com.dmc.bootcamp.repository.RecordRepository;
import com.dmc.bootcamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    @Autowired
    private final RecordRepository recordRepository;

    @Autowired
    private final UserRepository userRepository;


    public Record saveRecord(String userId,RecordRequest recordRequest){
        AppUser user= userRepository.findUserByUserId(userId);
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

    public List<Record> findRecordByUserId(String userId){
        AppUser user= userRepository.findUserByUserId(userId);
        if (user==null){
            throw new IllegalArgumentException("User not found");
        }
        return recordRepository.findRecordByAppUser(user);
    }

    @Transactional
    public void updateRecord(long id, UpdateRecordRequest request){
        Record record = recordRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Record not found"));
        record.update(id,request.getScore());
    }


    public void deleteRecord(long id) {
        recordRepository.deleteById(id);
    }


    public List<Record> getRecordsByUserId(String userId){
        AppUser user= userRepository.findUserByUserId(userId);
        if (user==null){
            throw new IllegalArgumentException("User not found");
        }
        return recordRepository.findRecordsByUserId(userId);
    }

}
