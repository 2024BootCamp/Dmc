package com.dmc.bootcamp.controller;

import com.dmc.bootcamp.domain.Record;
import com.dmc.bootcamp.dto.request.RecordRequest;
import com.dmc.bootcamp.dto.response.RecordResponse;
import com.dmc.bootcamp.service.RecordService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class RecordController {

    private final RecordService recordService;


    @PostMapping("/record/add") //식사 기록 등록
    public ResponseEntity<Record> addRecord(@RequestBody RecordRequest request){
        Record record=recordService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(record);
    }

    @GetMapping("/record/get")//식사 기록 조회
    public ResponseEntity<List<RecordResponse>> getAllRecord(){
        List<RecordResponse> lists= recordService.getAll().stream().map(RecordResponse::new).toList();

        return ResponseEntity.ok().body(lists);
    }

}
