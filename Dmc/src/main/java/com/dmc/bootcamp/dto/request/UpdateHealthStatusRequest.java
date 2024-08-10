package com.dmc.bootcamp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateHealthStatusRequest {
    private  float highBlood;
    private float lowBlood;
    private float emptySugar;
    private float fullSugar;
}
