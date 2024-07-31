package com.dmc.bootcamp.dto.response;

import com.dmc.bootcamp.domain.FoodRating;
import lombok.Getter;

@Getter
public class FoodRatingResponse {
    private float rating;
    private float starRating;

    public FoodRatingResponse(FoodRating foodRating) {
        this.rating = foodRating.getRating();
        this.starRating = foodRating.getStarRating();
    }
}
