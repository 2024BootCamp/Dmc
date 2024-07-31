package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.FoodRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRatingRepository extends JpaRepository<FoodRating, Long> {
}
