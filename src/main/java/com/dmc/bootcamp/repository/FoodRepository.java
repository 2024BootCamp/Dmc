package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,String > {
}
