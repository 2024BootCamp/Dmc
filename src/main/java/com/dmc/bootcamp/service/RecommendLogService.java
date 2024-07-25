package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Food;
import com.dmc.bootcamp.domain.RecommendLog;
import com.dmc.bootcamp.dto.FoodDTO;
import com.dmc.bootcamp.dto.request.RecommendLogRequest;
import com.dmc.bootcamp.repository.RecommendLogRepository;
import com.dmc.bootcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendLogService {

    private final RecommendLogRepository recommendLogRepository;

    @Autowired
    private FoodService foodService; // FoodDTO로 변환하기 위해 필요

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
}
