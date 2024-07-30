package com.dmc.bootcamp.controller;


import com.dmc.bootcamp.dto.request.RecordRequest;
import com.dmc.bootcamp.dto.response.RecordResponse;
import com.dmc.bootcamp.service.RecordService;
import com.dmc.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dmc.bootcamp.domain.Record;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class RecordController {

    @Autowired
    private RecordService recordService;

    @Autowired
    private UserService userService;


    @PostMapping("/addRecord")
    public ResponseEntity<Record> addRecord(@RequestBody RecordRequest request){
        Record record = recordService.saveRecord(request);
        return  ResponseEntity.ok().body(record);
    }

    @GetMapping("/getAllRecord")
    public ResponseEntity<List<RecordResponse>> getAll(){
        List<RecordResponse> list = recordService.getAllRecords().stream()
                .map(RecordResponse::new)
                .collect(Collectors.toList());
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping("/getDetail/{recordId}")
    public ResponseEntity<RecordResponse>  getDetail(@PathVariable Long recordId){
        Record record=recordService.getRecordById(recordId);
        RecordResponse response= new RecordResponse(record);
        return  ResponseEntity.ok().body(response);
    }


}
