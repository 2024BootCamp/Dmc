package com.dmc.bootcamp.dto.request;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.FoodRating;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodRatingRequest {
    private float rating;
    private float starRating;

    public FoodRating toEntity(AppUser user) {
        return FoodRating.builder()
                .rating(rating)
                .starRating(starRating)
                .user(user)
                .build();
    }
}
