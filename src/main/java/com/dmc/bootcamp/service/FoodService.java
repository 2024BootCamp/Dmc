package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.Food;
import com.dmc.bootcamp.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import java.util.Optional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {
    //쿼리
    @Autowired
    private final FoodRepository foodRepository;

    public List<Food> getAllFood(){
        List<Food> foodList= foodRepository.findAll();
        return foodList;
    }

    //쿼리
    //밥 검색
    public Optional<Food> getRandomFoodByPrefixesAndNutrients() {
        return foodRepository.findRandomFoodByPrefixesAndNutrients();
    }
    //국 검색
    public Optional<Food> getRandomSoupByPrefixesAndNutrients() {
        return foodRepository.findRandomSoupByPrefixesAndNutrients();
    }

    //나물 무침 검색
    public Optional<Food> getRandomNamulMoochimByNutrients() {
        return foodRepository.findRandomNamulMoochimByNutrients();
    }
    //찜, 구이 검색
    public Optional<Food> getRandomJjimGuiByNutrients() {
        return foodRepository.findRandomJjimGuiByNutrients();
    }

}
