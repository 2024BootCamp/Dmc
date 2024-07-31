package com.dmc.bootcamp.controller;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.dto.request.FoodRatingRequest;
import com.dmc.bootcamp.dto.response.FoodRatingResponse;
import com.dmc.bootcamp.dto.response.MealRatingResponse;
import com.dmc.bootcamp.service.FoodRatingService;
import com.dmc.bootcamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
public class FoodRatingController {
    private final FoodRatingService foodRatingService;
    private final UserService userService;

    @PostMapping
    public FoodRatingResponse createRating(@RequestBody FoodRatingRequest request, @RequestParam String userId) {
        return new FoodRatingResponse(foodRatingService.createRating(request, userId));
    }

    @GetMapping("/{id}")
    public FoodRatingResponse getRating(@PathVariable Long id) {
        return new FoodRatingResponse(foodRatingService.getRating(id));
    }

    @PostMapping("/score/{recordId}")
    public ResponseEntity<Float> getScore(@PathVariable long recordId) {
        JwtAuthenticationToken auth = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName(); // 인증된 사용자의 ID

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        float score = foodRatingService.rating(recordId, userId);
        return ResponseEntity.ok().body(score);
    }
}

