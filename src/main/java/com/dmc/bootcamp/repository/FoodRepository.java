package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

//쿼리 import
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food,String > {

    //밥 종류 검색 100g기준 염분 50mg이하(50.0), 당 2g이하(0.2)
    @Query(value = "SELECT * FROM food_data WHERE (food_id LIKE 'D101%' OR food_id LIKE 'D301%' OR food_id LIKE 'D401%' OR food_id LIKE 'D501%' OR food_id LIKE 'D601%' OR food_id LIKE 'D701%') AND sodium <= 50.0 AND sugar <= 2.0 ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Food> findRandomFoodByPrefixesAndNutrients();

    //국 종류 검색 100g기준 염분 250mg이하(250.0), 당 3g이하 (0.3)
    @Query(value = "SELECT * FROM food_data WHERE (food_id LIKE 'D105%' OR food_id LIKE 'D305%' OR food_id LIKE 'D405%' OR food_id LIKE 'D505%' OR food_id LIKE 'D605%' OR food_id LIKE 'D705%' OR food_id LIKE 'D106%' OR food_id LIKE 'D306%' OR food_id LIKE 'D406%' OR food_id LIKE 'D506%' OR food_id LIKE 'D606%' OR food_id LIKE 'D706%') AND sodium <= 250.0 AND sugar <= 0.3 ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Food> findRandomSoupByPrefixesAndNutrients();

    //반찬 검색 나물, 무침류
    @Query(value = "SELECT * FROM food_data WHERE (food_id LIKE 'D113%' OR food_id LIKE 'D114%' OR food_id LIKE 'D313%' OR food_id LIKE 'D314%' OR food_id LIKE 'D413%' OR food_id LIKE 'D414%' OR food_id LIKE 'D513%' OR food_id LIKE 'D514%' OR food_id LIKE 'D613%' OR food_id LIKE 'D614%' OR food_id LIKE 'D713%' OR food_id LIKE 'D714%') AND sodium <= 200.0 AND sugar <= 0.5 ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Food> findRandomNamulMoochimByNutrients();
    //반찬 검색 찜, 구이류
    @Query(value = "SELECT * FROM food_data WHERE (food_id LIKE 'D108%' OR food_id LIKE 'D308%' OR food_id LIKE 'D408%' OR food_id LIKE 'D508%' OR food_id LIKE 'D608%' OR food_id LIKE 'D107%' OR food_id LIKE 'D307%' OR food_id LIKE 'D407%' OR food_id LIKE 'D507%' OR food_id LIKE 'D607%' OR food_id LIKE 'D707%') AND sodium <= 200.0 AND sugar <= 0.5 ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Food> findRandomJjimGuiByNutrients();
}
