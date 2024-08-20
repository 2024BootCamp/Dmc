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
import java.util.*;
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
    public RecommendLog saveRecommendationLog(String userId, List<Food> foods) {
        AppUser user = userRepository.findUserByUserId(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        RecommendLog recommendLog = new RecommendLog();
        recommendLog.setRecomTime(LocalDateTime.now());
        recommendLog.setAppUser(user);
        recommendLog.setFoods(foods);

        return recommendLogRepository.save(recommendLog);  // RecommendLog 객체 반환
    }


    //호불호 조사
    public RecommendLog updateLikeStatus(String recommendId, boolean like) {
        long recomId = Long.parseLong(recommendId);
       RecommendLog recommendLog= recommendLogRepository.findByRecommendId(recomId);
        if(like){
            recommendLog.setLikeStatus(like);
        }
        else {
            recommendLog.setLikeStatus(false);
        }
        return recommendLogRepository.save(recommendLog);
    }

    @Transactional
    public List<RecommendCountFood> getRecommendCountByDate(LocalDate date) {
        List<RecommendLog> logs = recommendLogRepository.findByDate(date);
        List<RecommendCountFood> recommendCountFoods = new ArrayList<>();

        for (RecommendLog log : logs) {
            List<Food> foods = recomFoodRepository.findFoodsByRecommendId(log.getRecommendId());
            int batchSize = 4;
            for (int i = 0; i < foods.size(); i += batchSize) {
                List<Food> mealFoods = foods.subList(i, Math.min(i + batchSize, foods.size()));
                RecommendCountFood recommendCountFood = new RecommendCountFood(
                        mealFoods.stream().map(FoodResponse::new).collect(Collectors.toList()),
                        log.getRecommendId() // 여기에 recommendId를 추가
                );
                recommendCountFoods.add(recommendCountFood);
            }
        }

        return recommendCountFoods;
    }

}



