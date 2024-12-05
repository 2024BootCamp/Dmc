package com.dmc.bootcamp.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MealRatingRequest {
    private List<MealDto> meals;
    private String userId;

    @Getter
    @Setter
    public static class MealDto {
        private String foodName;
        private double quantity;
    }
}
