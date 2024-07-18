package com.dmc.bootcamp.controller;

import com.dmc.bootcamp.domain.HealthStatus;
import com.dmc.bootcamp.dto.request.HealthStatusRequest;
import com.dmc.bootcamp.dto.request.UpdateHealthStatusRequest;
import com.dmc.bootcamp.dto.response.HealthStatusResponse;
import com.dmc.bootcamp.service.HealthStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class HealthStatusController {

    private final HealthStatusService healthStatusService;

    @PostMapping("/add")
    public ResponseEntity<HealthStatus> addStatus(@RequestBody HealthStatusRequest request){
        HealthStatus addHealthStatus= healthStatusService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addHealthStatus);
    }

    @GetMapping("/get")
    public ResponseEntity<List<HealthStatusResponse>> getAll(){
        List<HealthStatusResponse> lists= healthStatusService.getAll().stream().map(HealthStatusResponse::new).toList();
        return ResponseEntity.ok().body(lists);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHealthStatus(@PathVariable Long id){
        healthStatusService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<HealthStatus> updateHealthStatus(@PathVariable long id, @RequestBody UpdateHealthStatusRequest request){
        HealthStatus updateHealthStatus= healthStatusService.update(id,request);
        return ResponseEntity.ok().body(updateHealthStatus);
    }
}
