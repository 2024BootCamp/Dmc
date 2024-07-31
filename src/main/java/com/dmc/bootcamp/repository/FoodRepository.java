package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

//쿼리 import
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
<<<<<<< HEAD

import java.util.List;
=======
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food,String > {

    //밥 종류 검색
    @Query(value = "SELECT * FROM food_data WHERE (food_id LIKE 'D101%' OR food_id LIKE 'D301%' OR food_id LIKE 'D401%' OR food_id LIKE 'D501%' OR food_id LIKE 'D601%' OR food_id LIKE 'D701%') ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Food> findRandomFoodByPrefixesAndNutrients();

    //국 종류 검색
    @Query(value = "SELECT * FROM food_data WHERE (food_id LIKE 'D105%' OR food_id LIKE 'D305%' OR food_id LIKE 'D405%' OR food_id LIKE 'D505%' OR food_id LIKE 'D605%' OR food_id LIKE 'D705%' OR food_id LIKE 'D106%' OR food_id LIKE 'D306%' OR food_id LIKE 'D406%' OR food_id LIKE 'D506%' OR food_id LIKE 'D606%' OR food_id LIKE 'D706%') ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Food> findRandomSoupByPrefixesAndNutrients();

    //반찬 검색 나물, 무침류
    @Query(value = "SELECT * FROM food_data WHERE (food_id LIKE 'D113%' OR food_id LIKE 'D114%' OR food_id LIKE 'D313%' OR food_id LIKE 'D314%' OR food_id LIKE 'D413%' OR food_id LIKE 'D414%' OR food_id LIKE 'D513%' OR food_id LIKE 'D514%' OR food_id LIKE 'D613%' OR food_id LIKE 'D614%' OR food_id LIKE 'D713%' OR food_id LIKE 'D714%') ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Food> findRandomNamulMoochimByNutrients();
    //반찬 검색 찜, 구이류
    @Query(value = "SELECT * FROM food_data WHERE (food_id LIKE 'D108%' OR food_id LIKE 'D308%' OR food_id LIKE 'D408%' OR food_id LIKE 'D508%' OR food_id LIKE 'D608%' OR food_id LIKE 'D107%' OR food_id LIKE 'D307%' OR food_id LIKE 'D407%' OR food_id LIKE 'D507%' OR food_id LIKE 'D607%' OR food_id LIKE 'D707%') ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Food> findRandomJjimGuiByNutrients();


    //환자
    //밥 종류 검색
    @Query(value = "SELECT * FROM food_data WHERE (food_id LIKE 'D101%' OR food_id LIKE 'D301%' OR food_id LIKE 'D401%' OR food_id LIKE 'D501%' OR food_id LIKE 'D601%' OR food_id LIKE 'D701%') AND sodium <= 23 AND sugar <=0.9 ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Food> findRandomRiceForPatient();

    //국 종류 검색
    @Query(value = "SELECT * FROM food_data WHERE (food_id LIKE 'D105%' OR food_id LIKE 'D305%' OR food_id LIKE 'D405%' OR food_id LIKE 'D505%' OR food_id LIKE 'D605%' OR food_id LIKE 'D705%' OR food_id LIKE 'D106%' OR food_id LIKE 'D306%' OR food_id LIKE 'D406%' OR food_id LIKE 'D506%' OR food_id LIKE 'D606%' OR food_id LIKE 'D706%') AND sodium <= 100 AND sugar <=1.2 ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Food> findRandomSoupForPatient();

    //반찬 검색 나물, 무침류
    @Query(value = "SELECT * FROM food_data WHERE (food_id LIKE 'D113%' OR food_id LIKE 'D114%' OR food_id LIKE 'D313%' OR food_id LIKE 'D314%' OR food_id LIKE 'D413%' OR food_id LIKE 'D414%' OR food_id LIKE 'D513%' OR food_id LIKE 'D514%' OR food_id LIKE 'D613%' OR food_id LIKE 'D614%' OR food_id LIKE 'D713%' OR food_id LIKE 'D714%') ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Food> findRandomNamulMoochimForPatient();

    //반찬 검색 찜, 구이류
    @Query(value = "SELECT * FROM food_data WHERE (food_id LIKE 'D108%' OR food_id LIKE 'D308%' OR food_id LIKE 'D408%' OR food_id LIKE 'D508%' OR food_id LIKE 'D608%' OR food_id LIKE 'D107%' OR food_id LIKE 'D307%' OR food_id LIKE 'D407%' OR food_id LIKE 'D507%' OR food_id LIKE 'D607%' OR food_id LIKE 'D707%') AND sodium <= 74 AND sugar <=1.8 ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Food> findRandomJjimGuiForPatient();
<<<<<<< HEAD

    //추천식단을 postman에서 조회가능하도록 쿼리 작성
//    @Query("SELECT f FROM Food f WHERE f.foodId IN (SELECT rf.foodId FROM RecomFood rf WHERE rf.recommendId = :recommendId)")
//    List<Food> findFoodsByRecommendId(@Param("recommendId") Long recommendId);

    //추천 식단 조회를 위한 리포지토리 메서드 추가
    @Query(value = "SELECT rf.food FROM RecomFood rf WHERE rf.recommendLog.recommendId = :recommendId",nativeQuery = true)
    List<Food> findFoodsByRecommendId(@Param("recommendId") Long recommendId);

    //Food findFoodByFoodName(String foodName);


    //음식 찾지 수량 제한
    @Query(value = "select * from food_data where food_data.food_name = :foodName limit 1;",nativeQuery = true)
    Food findFoodByFoodName(@Param("foodName") String foodName);
=======
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
}
