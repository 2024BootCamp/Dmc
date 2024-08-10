package com.dmc.bootcamp.controller;


import com.dmc.bootcamp.dto.response.RecommendCountFood;
import com.dmc.bootcamp.service.RecommendLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/recommend")
public class RecommendationController {
    @Autowired
    private RecommendLogService recommendLogService;

    @GetMapping("/by-date")
    public ResponseEntity<List<RecommendCountFood>> getRecommendCountByDate(@RequestParam("date") LocalDate date) {
        List<RecommendCountFood> recommendCountFoods = recommendLogService.getRecommendCountByDate(date);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8); // 명시적으로 UTF-8 인코딩 설정
        return ResponseEntity.ok().headers(headers).body(recommendCountFoods);
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
