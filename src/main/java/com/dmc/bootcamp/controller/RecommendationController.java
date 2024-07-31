package com.dmc.bootcamp.controller;

import com.dmc.bootcamp.domain.Food;
import com.dmc.bootcamp.dto.request.RecommendLogRequest;
import com.dmc.bootcamp.dto.response.FoodResponse;
import com.dmc.bootcamp.dto.response.RecommendCountFood;
import com.dmc.bootcamp.service.RecommendLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {
    @Autowired
    private RecommendLogService recommendLogService;

    //날짜로 그 날 추천식단 조회
    //http://localhost:8081/recommend/by-date?date=2024-07-30 예시 url
//    @GetMapping("/by-date")
//    public List<RecommendCountFood> getRecommendedFoodsByDate(@RequestParam("date") String date) {
//        LocalDate localDate = LocalDate.parse(date); // 날짜 형식이 'yyyy-MM-dd'인 경우
//        List<Food> foods = recommendLogService.getFoodsByRecommendationDate(localDate);
//        return foods.stream()
//                .map(FoodResponse::new)
//                .collect(Collectors.toList());
//    }
    @GetMapping("/by-date")
    public ResponseEntity<List<RecommendCountFood>> getRecommendCountByDate(@RequestParam("date") LocalDate date) {
        List<RecommendCountFood> recommendCountFoods = recommendLogService.getRecommendCountByDate(date);
        return ResponseEntity.ok().body(recommendCountFoods);
    }

//    @GetMapping("/by-date")
//    public ResponseEntity<RecommendCountFood> getRecommendCountByDate(@RequestParam LocalDate date) {
//        LocalDate localDate= LocalDate.now();
//        List<FoodResponse> foods= recommendLogService.getRecommendCountByDate(localDate).stream().map(FoodResponse:: new).toList();
//        Map<String,Float> map= new HashMap<>();
//        float kcal= 0;
//        float sodium=0;
//        float sugar=0;
//        for(FoodResponse food:foods){
//            kcal+= food.getCalories();
//            sodium+= food.getSodium();
//            sugar+= food.getSugar();
//        }
//        map.put("kcal",kcal);
//        map.put("sodium",sodium);
//        map.put("sugar",sugar);
//        RecommendCountFood recommendCountFood= new RecommendCountFood(foods,map);
//        return ResponseEntity.ok().body(recommendCountFood);
//    }
}
