package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Food;
import com.dmc.bootcamp.domain.RecommendLog;
import com.dmc.bootcamp.repository.RecomFoodRepository;
import com.dmc.bootcamp.repository.RecommendLogRepository;
import com.dmc.bootcamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendLogService {

    @Autowired
    private final RecommendLogRepository recommendLogRepository;
    @Autowired
    private final RecomFoodRepository recomFoodRepository;

    @Autowired
    private final  FoodService foodService; // FoodDTO로 변환하기 위해 필요

    @Autowired
    private final UserRepository userRepository;


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

    public List<Food> getFoodsByRecommendationDate(LocalDate date) {
        List<RecommendLog> logs = recommendLogRepository.findByDate(date);
        List<Food> allFoods = new ArrayList<>();

        for (RecommendLog log : logs) {
            List<Food> foods = recomFoodRepository.findFoodsByRecommendId(log.getRecommendId());
            allFoods.addAll(foods);
        }

        return allFoods;
    }
}
