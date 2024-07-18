package com.dmc.bootcamp.controller;

import com.dmc.bootcamp.domain.Food;
import com.dmc.bootcamp.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @GetMapping("/food")
    public ResponseEntity<List<Food>> getListFood(){
        List<Food> list= foodService.getAllFood();
        return ResponseEntity.ok().body(list);
    }
}
