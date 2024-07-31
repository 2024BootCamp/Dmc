package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Food;
import com.dmc.bootcamp.domain.RecommendLog;
import com.dmc.bootcamp.dto.response.FoodResponse;
import com.dmc.bootcamp.dto.response.RecommendCountFood;
import com.dmc.bootcamp.repository.RecomFoodRepository;
import com.dmc.bootcamp.repository.RecommendLogRepository;
import com.dmc.bootcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecommendLogService {

    private final RecommendLogRepository recommendLogRepository;
    private final RecomFoodRepository recomFoodRepository;

    @Autowired
    private FoodService foodService; // FoodDTO로 변환하기 위해 필요

    private final UserRepository userRepository;

    @Autowired
    public RecommendLogService(RecommendLogRepository recommendLogRepository, RecomFoodRepository recomFoodRepository, UserRepository userRepository) {
        this.recommendLogRepository = recommendLogRepository;
        this.recomFoodRepository = recomFoodRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveRecommendationLog(String userId, List<Food> foods) {
        AppUser user = userRepository.findUserByUserId(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        RecommendLog recommendLog = new RecommendLog();
        recommendLog.setRecomTime(LocalDateTime.now());
        recommendLog.setAppUser(user);
        recommendLog.setFoods(foods);

        recommendLogRepository.save(recommendLog);
    }
    @Transactional
    public List<RecommendCountFood> getRecommendCountByDate(LocalDate date) {
        // 날짜에 해당하는 추천 로그를 가져온다.
        List<RecommendLog> logs = recommendLogRepository.findByDate(date);
        List<RecommendCountFood> recommendCountFoods = new ArrayList<>();

        // 각 추천 로그의 recommend_id에 따라 음식을 가져오고, 4개씩 묶어서 식단을 구성한다.
        for (RecommendLog log : logs) {
            // recommend_id를 기반으로 음식을 가져온다.
            List<Food> foods = recomFoodRepository.findFoodsByRecommendId(log.getRecommendId());

            // 4개씩 묶어서 식단을 구성한다.
            int batchSize = 4;
            for (int i = 0; i < foods.size(); i += batchSize) {
                List<Food> mealFoods = foods.subList(i, Math.min(i + batchSize, foods.size()));

                // 식단과 관련된 RecommendCountFood 객체를 생성한다.
                RecommendCountFood recommendCountFood = new RecommendCountFood(
                        mealFoods.stream().map(FoodResponse::new).collect(Collectors.toList())
                );

                // 결과 리스트에 추가한다.
                recommendCountFoods.add(recommendCountFood);
            }
        }

        return recommendCountFoods;
    }

}
//    @Transactional
//    public List<RecommendCountFood> getRecommendCountByDate(LocalDate date) {
//        // 날짜에 해당하는 추천 로그를 가져온다.
//        List<RecommendLog> logs = recommendLogRepository.findByDate(date);
//        List<RecommendCountFood> recommendCountFoods = new ArrayList<>();
//
//        // 각 추천 로그의 recommend_id에 따라 음식을 가져오고, 총 영양 정보를 계산한다.
//        for (RecommendLog log : logs) {
//            // recommend_id를 기반으로 음식을 가져온다.
//            List<Food> foods = recomFoodRepository.findFoodsByRecommendId(log.getRecommendId());
//
//            // 4개씩 묶어서 식단을 구성한다.
//            int batchSize = 4;
//            for (int i = 0; i < foods.size(); i += batchSize) {
//                List<Food> mealFoods = foods.subList(i, Math.min(i + batchSize, foods.size()));
//
//                // 총 영양 정보를 계산한다.
//                float kcal = 0;
//                float sodium = 0;
//                float sugar = 0;
//                for (Food food : mealFoods) {
//                    kcal += food.getCalories();
//                    sodium += food.getSodium();
//                    sugar += food.getSugar();
//                }
//
//                // 영양 정보를 담을 Map을 생성한다.
//                Map<String, Float> nutritionMap = new HashMap<>();
//                nutritionMap.put("kcal", kcal);
//                nutritionMap.put("sodium", sodium);
//                nutritionMap.put("sugar", sugar);
//
//                // 식단과 영양 정보를 담은 RecommendCountFood 객체를 생성한다.
//                RecommendCountFood recommendCountFood = new RecommendCountFood(
//                        mealFoods.stream().map(FoodResponse::new).collect(Collectors.toList()), nutritionMap);
//
//                // 결과 리스트에 추가한다.
//                recommendCountFoods.add(recommendCountFood);
//            }
//        }
//
//        return recommendCountFoods;
//    }


