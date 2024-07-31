package com.dmc.bootcamp.controller;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Food;

import com.dmc.bootcamp.dto.response.FoodResponse;
import com.dmc.bootcamp.dto.response.RecommendCountFood;
import com.dmc.bootcamp.service.FoodService;
import com.dmc.bootcamp.service.RecommendLogService;
import com.dmc.bootcamp.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private final UserService userService;
    private final RecommendLogService recommendLogService;
    @GetMapping("/recommend-meal")
    public ResponseEntity<RecommendCountFood> recommendMeal() {

        JwtAuthenticationToken auth = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName(); // 인증된 사용자의 ID
        AppUser user= userService.findById(userId);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        List<FoodResponse> list = foodService.getMeal(userId).stream().map(FoodResponse::new).toList();

        List<Food> recommendedFoods = foodService.getMeal(userId);


        //총합 kcal,sodium,sugar

        float kcal= 0;
        float sodium= 0;
        float sugar=0;
        for(Food food : recommendedFoods) {
            kcal+= food.getCalories();
            sodium+= food.getSodium();
            sugar+= food.getSugar();
        }
        Map<String,Float> map = new HashMap<>();
        map.put("kcal",kcal);
        map.put("sodium",sodium);
        map.put("sugar",sugar);

        recommendLogService.saveRecommendationLog(userId, recommendedFoods);
        RecommendCountFood recommendCountFood= new RecommendCountFood(list,map);

        return ResponseEntity.ok().body(recommendCountFood);
    }

    @GetMapping("/recommend/{recommendId}")
    public ResponseEntity<List<Food>> getFoodsByRecommendId(@PathVariable Long recommendId) {
        List<Food> foods = foodService.getFoodsByRecommendId(recommendId);
        if (foods.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(foods);
    }




}
