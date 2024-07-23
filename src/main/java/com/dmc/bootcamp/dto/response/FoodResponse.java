package com.dmc.bootcamp.dto.response;
//내가 추가
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodResponse {
    private String foodId;
    private String foodName;
    private String servingSize;
    private float calories;
    private float carbohydrate;
    private float protein;
    private float fat;
    private float sodium;
    private float sugar;
}