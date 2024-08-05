package com.dmc.bootcamp.controller;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.HealthStatus;
import com.dmc.bootcamp.dto.request.HealthStatusRequest;
import com.dmc.bootcamp.dto.request.UpdateHealthStatusRequest;
import com.dmc.bootcamp.dto.response.HealthStatusResponse;
import com.dmc.bootcamp.service.HealthStatusService;
import com.dmc.bootcamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class HealthStatusController {

    private final HealthStatusService healthStatusService;
    private final UserService userService;

    @PostMapping("/addHealthStastus")// 건강 기록 추
    public ResponseEntity<HealthStatus> addStatus(@RequestBody HealthStatusRequest request){
        HealthStatus addHealthStatus= healthStatusService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addHealthStatus);
    }

    @GetMapping("/getHealthStatus")// 건강 기록  모두 조회
    public ResponseEntity<List<HealthStatusResponse>> getAll(){
        List<HealthStatusResponse> lists= healthStatusService.getAll().stream().map(HealthStatusResponse::new).toList();
        return ResponseEntity.ok().body(lists);

    }
    
    @GetMapping("/getHealthStatusByUserId")// 유저 Id에 따라 간강관리 상태를 다 건내기
    public ResponseEntity<List<HealthStatusResponse>> getAllHealthStatus(){
        JwtAuthenticationToken auth = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName(); // 인증된 사용자의 ID
        AppUser user = userService.findById(userId);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        List<HealthStatusResponse> lists= healthStatusService.getALlStatusByUserId(userId).stream().map(HealthStatusResponse::new).toList();
        return ResponseEntity.ok().body(lists);
    }

    @DeleteMapping("/deleteHealthStatus/{id}") // 건강 기록를 삭제
    public ResponseEntity<Void> deleteHealthStatus(@PathVariable Long id){
        healthStatusService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/putHealthStatus/{id}") // 건강 기록 수정
    public ResponseEntity<HealthStatus> updateHealthStatus(@PathVariable long id, @RequestBody UpdateHealthStatusRequest request){
        HealthStatus updateHealthStatus= healthStatusService.update(id,request);
        return ResponseEntity.ok().body(updateHealthStatus);
    }
}
