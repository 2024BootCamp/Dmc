package com.dmc.bootcamp.controller;

<<<<<<< HEAD
import com.dmc.bootcamp.domain.Food;
import com.dmc.bootcamp.dto.response.FoodResponse;
import com.dmc.bootcamp.service.RecommendLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
=======
import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.dto.FoodDTO;

import com.dmc.bootcamp.dto.response.RecommendationResponse;

import com.dmc.bootcamp.service.RecommendLogService;
import com.dmc.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608

@RestController
@RequestMapping("/recommend")
public class RecommendationController {
    @Autowired
    private RecommendLogService recommendLogService;

<<<<<<< HEAD
    //날짜로 그 날 추천식단 조회
    //http://localhost:8081/recommend/by-date?date=2024-07-30 예시 url
    @GetMapping("/by-date")
    public List<FoodResponse> getRecommendedFoodsByDate(@RequestParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date); // 날짜 형식이 'yyyy-MM-dd'인 경우
        List<Food> foods = recommendLogService.getFoodsByRecommendationDate(localDate);
        return foods.stream()
                .map(FoodResponse::new)
                .collect(Collectors.toList());
    }
=======
    @Autowired
    private UserService pserService; // 필요 시



>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
}
