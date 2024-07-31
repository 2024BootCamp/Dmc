package com.dmc.bootcamp.dto.response;
//내가 추가
import com.dmc.bootcamp.domain.Food;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodResponse {
    private String foodName;

    public FoodResponse(Food food){
        this.foodName=food.getFoodName();

    }
}