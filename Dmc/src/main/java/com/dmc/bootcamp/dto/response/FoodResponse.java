package com.dmc.bootcamp.dto.response;
//내가 추가
import com.dmc.bootcamp.domain.Food;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodResponse {
    private String foodName;
    private  float calories;
    private float carbohydrate;
    private  float protein;
    private float fat;
    private  float sodium;
    private float sugar;

    public FoodResponse(Food food){
        this.foodName=food.getFoodName();
        this.calories=food.getCalories();
        this.carbohydrate=food.getCarbohydrate();
        this.protein=food.getProtein();
        this.fat =food.getFat();
        this.sodium =food.getSodium();
        this.sugar =food.getSugar();

    }
}