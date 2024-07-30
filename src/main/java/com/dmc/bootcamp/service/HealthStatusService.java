package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.HealthStatus;
import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.dto.request.HealthStatusRequest;
import com.dmc.bootcamp.dto.request.UpdateHealthStatusRequest;
import com.dmc.bootcamp.repository.HealthStatusRepository;
import com.dmc.bootcamp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HealthStatusService {
    private final HealthStatusRepository healthStatusRepository;
    private final UserRepository userRepository;

    //건강 상태 기록 저장
    public HealthStatus save(HealthStatusRequest request){
        AppUser user= userRepository.findById(request.getUserId()).orElseThrow(()-> new IllegalArgumentException("not found"+request.getUserId()));
       return healthStatusRepository.save(request.toEntity(user));
    }

    //사용자 건강 상태 기록 조회
    public List<HealthStatus> getAll(){
        return healthStatusRepository.findAll();
    }

    //사용자 건강 상태 기록 삭제
    public void delete(long id){
        HealthStatus healthStatus= healthStatusRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found"+id));
        healthStatusRepository.delete(healthStatus);
    }


    //사용자 건강 상태 기록 업데이트
    @Transactional
    public HealthStatus update(long id, UpdateHealthStatusRequest request){
        HealthStatus healthStatus= healthStatusRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found: "+id));
        healthStatus.update(request.getHighBlood(), request.getLowBlood(), request.getEmptySugar(), request.getFullSugar());
        return healthStatus;
    }

}
