package com.dmc.bootcamp.dto.response;

import com.dmc.bootcamp.dto.FoodDTO;

import java.util.List;

public class RecommendationResponse {
    private FoodDTO rice;
    private FoodDTO soup;
    private List<FoodDTO> banchans;

    // Constructors, Getters, Setters
    public RecommendationResponse(FoodDTO rice, FoodDTO soup, List<FoodDTO> banchans) {
        this.rice = rice;
        this.soup = soup;
        this.banchans = banchans;
    }

    // Getters and Setters
}