package com.dmc.bootcamp.dto.response;

import com.dmc.bootcamp.domain.HealthStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class HealthStatusResponse {
    private  float highBlood;
    private float lowBlood;
    private float emptySugar;
    private float fullSugar;
    private String userId;
    private LocalDateTime date;
    private long statusId;

    public HealthStatusResponse(HealthStatus healthStatus){
        this.statusId=healthStatus.getStatusId();
        this.highBlood=healthStatus.getHighBlood();
        this.lowBlood=healthStatus.getLowBlood();
        this.emptySugar=healthStatus.getEmptySugar();
        this.fullSugar=healthStatus.getFullSugar();
        this.userId=healthStatus.getUser().getUserId();
        this.date=healthStatus.getStatusTime();
    }
}
