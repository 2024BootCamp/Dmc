package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Record;
import com.dmc.bootcamp.dto.request.RecordRequest;
import com.dmc.bootcamp.dto.request.UpdateRecordRequest;
import com.dmc.bootcamp.repository.RecordRepository;
import com.dmc.bootcamp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final UserRepository userRepository;

    //사용자 식사 기록 저장
    public Record save(RecordRequest request){
        AppUser appUser = userRepository.findById(request.getUserId()).orElseThrow(()->new IllegalArgumentException("not found"+ request.getUserId()));
        return recordRepository.save(request.toEntity(appUser));
    }

    // 사용자 식사 기록 조회
    public List<Record> getAll(){
        return recordRepository.findAll();
    }

    // 사용자 식사 기록 삭제
    public void delete(long id){
        Record record= recordRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found"+id));
        recordRepository.delete(record);
    }

    //사용자 식사 업데이트
    @Transactional
    public Record update(long id, UpdateRecordRequest request){
        Record record= recordRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found"+id));
        record.update(request.getImage(),request.getContent(),request.getScore());
        return  record;
    }
}
