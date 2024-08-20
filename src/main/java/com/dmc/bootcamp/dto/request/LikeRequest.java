package com.dmc.bootcamp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeRequest {
    private String recommendId;
    private Boolean likeStatus;
}