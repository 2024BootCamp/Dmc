package com.dmc.bootcamp.controller;

import com.dmc.bootcamp.domain.Record;
import com.dmc.bootcamp.dto.request.RecordRequest;
import com.dmc.bootcamp.dto.request.UpdateRecordRequest;
import com.dmc.bootcamp.dto.response.RecordResponse;
import com.dmc.bootcamp.service.RecordService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor

public class RecordController {

    private final RecordService recordService;

//
//    @PostMapping("/record/add") //식사 기록 등록
//    public ResponseEntity<Record> addRecord(@RequestBody RecordRequest request){
//        Record record=recordService.save(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(record);
//    }
//
//    @GetMapping("/record/get")//식사 기록 조회
//    public ResponseEntity<List<RecordResponse>> getAllRecord(){
//        List<RecordResponse> lists= recordService.getAll().stream().map(RecordResponse::new).toList();
//
//        return ResponseEntity.ok().body(lists);
//    }
//
//    @PutMapping("/record/update/{id}") // 식사 기록 수정
//    public ResponseEntity<Record> updateRecord(@PathVariable Long id, @RequestBody UpdateRecordRequest request) {
//        Record updatedRecord = recordService.update(id, request);
//        return ResponseEntity.ok().body(updatedRecord);
//    }
//
//    @DeleteMapping("/record/delete/{id}") // 식사 기록 삭제
//    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
//        recordService.delete(id);
//        return ResponseEntity.noContent().build();
//    }

    @PostMapping("/addRecord")
    public ResponseEntity<Record> addRecord(@RequestBody RecordRequest recordRequest) {
        Record savedRecord = recordService.saveRecord(recordRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecord);
    }
}
