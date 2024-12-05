package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.Food;
import com.dmc.bootcamp.domain.RecomFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecomFoodRepository extends JpaRepository<RecomFood, Long> {

    @Query("SELECT f FROM Food f WHERE f.foodId IN (SELECT rf.foodId FROM RecomFood rf WHERE rf.recommendId = :recommendId)")
    List<Food> findFoodsByRecommendId(@Param("recommendId") Long recommendId);
}
