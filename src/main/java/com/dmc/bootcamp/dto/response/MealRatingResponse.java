package com.dmc.bootcamp.dto.response;

import lombok.Getter;

@Getter
public class MealRatingResponse {
    private double score;
    private double stars;

    public MealRatingResponse(double score, double stars) {
        this.score = score;
        this.stars = stars;
    }
}
