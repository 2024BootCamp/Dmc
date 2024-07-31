package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.*;
import com.dmc.bootcamp.domain.Record;
import com.dmc.bootcamp.dto.request.FoodRatingRequest;
import com.dmc.bootcamp.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FoodRatingService {

    private final UserRepository userRepository;
    private final FoodRatingRepository foodRatingRepository;
    private final FoodRepository foodRepository;
    private final RecordRepository recordRepository;

    public FoodRating createRating(FoodRatingRequest request, String userId) {
        AppUser user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        FoodRating foodRating = request.toEntity(user);
        return foodRatingRepository.save(foodRating);
    }

    public FoodRating getRating(Long id) {
        return foodRatingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rating not found"));
    }

    public float getAverageKcal(String userId) {
        AppUser user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        double averageKcal=0;
        LocalDate birthday = user.getBirthday();

        if (user.getGender().equals("M")) {
            averageKcal += 88.362 + (13.397 * user.getWeight()) + (4.799 * user.getHeight())
                    - (5.677 * Period.between(birthday, LocalDate.now()).getYears());
        } else {
            averageKcal += 447.593 + (9.247 * user.getWeight()) + (3.098 * user.getHeight())
                    - (4.330 * Period.between(birthday, LocalDate.now()).getYears());
        }

        return (float) averageKcal / 3;
    }

    public float rating(long recordId, String userId) {
        double personalKcal = getAverageKcal(userId);
        double kcalScore = getKcal(recordId);
        double sodiumScore = getSodium(recordId);
        double sugarScore = getSugar(recordId);
        double kcalCompare = personalKcal - kcalScore;
        float totalScore = 1;

        if (-100 < kcalCompare && kcalCompare < 100)
            kcalScore = 33;
        else if (-200 < kcalCompare && kcalCompare < 200)
            kcalScore = 22;
        else if (-300 < kcalCompare && kcalCompare < 300)
            kcalScore = 11;
        else
            kcalScore = 0;

        if (sodiumScore < 197)
            sodiumScore = 33;
        else if (sodiumScore < 247)
            sodiumScore = 22;
        else if (sodiumScore < 297)
            sodiumScore = 11;
        else
            sodiumScore = 0;

        if (sugarScore < 7.2)
            sugarScore = 33;
        else if (sugarScore < 9)
            sugarScore = 22;
        else if (sugarScore < 10.8)
            sugarScore = 11;
        else
            sugarScore = 0;

        totalScore += kcalScore + sodiumScore + sugarScore;
        return totalScore;
    }

    public double ratingStars(long recordId, String userId) {
        double score = rating(recordId, userId);
        return calculateStarRating(score);
    }

    public double calculateStarRating(double score) {
        return Math.max(0, Math.min(score / 20.0, 5));
    }

    private float getSodium(long recordId) {
        Record record = recordRepository.findById(recordId)
                .orElseThrow(() -> new IllegalArgumentException("Record not found"));
        Map<String, Float> listFood = record.getListMeal();
        float sodium = 0;
        for (Map.Entry<String, Float> entry : listFood.entrySet()) {
            Food food = foodRepository.findFoodByFoodName(entry.getKey());
            float gram = entry.getValue();
            sodium += food.getSodium() * gram * 0.01;
        }
        return sodium;
    }

    private float getSugar(long recordId) {
        Record record = recordRepository.findById(recordId)
                .orElseThrow(() -> new IllegalArgumentException("Record not found"));
        Map<String, Float> listFood = record.getListMeal();
        float sugar = 0;
        for (Map.Entry<String, Float> entry : listFood.entrySet()) {
            Food food = foodRepository.findFoodByFoodName(entry.getKey());
            float gram = entry.getValue();
            sugar += food.getSugar() * gram * 0.01;
        }
        return sugar;
    }

    private float getKcal(long recordId) {
        Record record = recordRepository.findById(recordId)
                .orElseThrow(() -> new IllegalArgumentException("Record not found"));
        Map<String, Float> listFood = record.getListMeal();
        float kcal = 0;
        for (Map.Entry<String, Float> entry : listFood.entrySet()) {
            Food food = foodRepository.findFoodByFoodName(entry.getKey());
            float gram = entry.getValue();
            kcal += food.getCalories() * gram * 0.01;
        }
        return kcal;
    }
}
