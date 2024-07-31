package com.dmc.bootcamp.controller;


<<<<<<< HEAD
import com.dmc.bootcamp.domain.AppUser;
=======
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
import com.dmc.bootcamp.dto.request.RecordRequest;
import com.dmc.bootcamp.dto.response.RecordResponse;
import com.dmc.bootcamp.service.RecordService;
import com.dmc.bootcamp.service.UserService;
<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
import org.springframework.web.bind.annotation.*;
import com.dmc.bootcamp.domain.Record;

import java.util.List;
import java.util.stream.Collectors;


@RestController
<<<<<<< HEAD
@RequiredArgsConstructor
public class RecordController {

    @Autowired
    private  final  UserService userService;

    @Autowired
    private final  RecordService recordService;
=======
public class RecordController {

    @Autowired
    private RecordService recordService;

    @Autowired
    private UserService userService;
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608


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
<<<<<<< HEAD
        JwtAuthenticationToken auth = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName(); // 인증된 사용자의 ID
        AppUser user= userService.findById(userId);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
=======
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
        Record record=recordService.getRecordById(recordId);
        RecordResponse response= new RecordResponse(record);
        return  ResponseEntity.ok().body(response);
    }


}
