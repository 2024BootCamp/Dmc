package com.dmc.bootcamp.dto.request;

import com.dmc.bootcamp.domain.HealthStatus;
import com.dmc.bootcamp.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HealthStatusRequest {

    private  float highBlood;
    private float lowBlood;
    private float emptySugar;
    private float fullSugar;
    private String userId;

    public HealthStatus toEntity(User user){
        return HealthStatus.builder()
                .highBlood(highBlood)
                .lowBlood(lowBlood)
                .emptySugar(emptySugar)
                .fullSugar(fullSugar)
                .user(user)
                .build();

    }
}
