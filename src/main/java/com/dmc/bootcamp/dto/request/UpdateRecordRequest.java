package com.dmc.bootcamp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRecordRequest {

    private String content;
    private String image;
    private float score;
}
