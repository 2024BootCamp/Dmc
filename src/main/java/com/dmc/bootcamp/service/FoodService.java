package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.Food;
import com.dmc.bootcamp.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;

    public List<Food> getAllFood(){
        List<Food> foodList= foodRepository.findAll();
        return foodList;
    }

}
