package com.dmc.bootcamp.controller;

import com.dmc.bootcamp.domain.Food;
import com.dmc.bootcamp.dto.response.FoodResponse;
import com.dmc.bootcamp.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;
//쿼리추가

@RestController
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @GetMapping("/food")
    public ResponseEntity<List<Food>> getListFood(){
        List<Food> list= foodService.getAllFood();
        return ResponseEntity.ok().body(list);
    }

    //쿼리 작성
    @GetMapping("/random-rice")
    public ResponseEntity<FoodResponse> getRandomFood() {
        Optional<Food> randomFood = foodService.getRandomFoodByPrefixesAndNutrients();
        if (randomFood.isPresent()) {
            Food food = randomFood.get();
            FoodResponse response = new FoodResponse(
                    food.getFoodId(),
                    food.getFoodName(),
                    food.getServingSize(),
                    food.getCalories(),
                    food.getCarbohydrate(),
                    food.getProtein(),
                    food.getFat(),
                    food.getSodium(),
                    food.getSugar()
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    //국 검색
    @GetMapping("/random-soup")
    public ResponseEntity<FoodResponse> getRandomSoup() {
        Optional<Food> randomSoup = foodService.getRandomSoupByPrefixesAndNutrients();
        if (randomSoup.isPresent()) {
            Food food = randomSoup.get();
            FoodResponse response = new FoodResponse(
                    food.getFoodId(),
                    food.getFoodName(),
                    food.getServingSize(),
                    food.getCalories(),
                    food.getCarbohydrate(),
                    food.getProtein(),
                    food.getFat(),
                    food.getSodium(),
                    food.getSugar()
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/random-banchan")
    public ResponseEntity<List<FoodResponse>> getRandomBanchan() {
        Optional<Food> randomNamulMoochim = foodService.getRandomNamulMoochimByNutrients();
        Optional<Food> randomJjimGui = foodService.getRandomJjimGuiByNutrients();

        if (randomNamulMoochim.isPresent() && randomJjimGui.isPresent()) {
            FoodResponse namulMoochimResponse = new FoodResponse(
                    randomNamulMoochim.get().getFoodId(),
                    randomNamulMoochim.get().getFoodName(),
                    randomNamulMoochim.get().getServingSize(),
                    randomNamulMoochim.get().getCalories(),
                    randomNamulMoochim.get().getCarbohydrate(),
                    randomNamulMoochim.get().getProtein(),
                    randomNamulMoochim.get().getFat(),
                    randomNamulMoochim.get().getSodium(),
                    randomNamulMoochim.get().getSugar()
            );

            FoodResponse jjimGuiResponse = new FoodResponse(
                    randomJjimGui.get().getFoodId(),
                    randomJjimGui.get().getFoodName(),
                    randomJjimGui.get().getServingSize(),
                    randomJjimGui.get().getCalories(),
                    randomJjimGui.get().getCarbohydrate(),
                    randomJjimGui.get().getProtein(),
                    randomJjimGui.get().getFat(),
                    randomJjimGui.get().getSodium(),
                    randomJjimGui.get().getSugar()
            );

            return ResponseEntity.ok(List.of(namulMoochimResponse, jjimGuiResponse));
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
