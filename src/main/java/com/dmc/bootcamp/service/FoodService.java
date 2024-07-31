package com.dmc.bootcamp.service;

import com.dmc.bootcamp.controller.UserController;
import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.domain.Food;
import com.dmc.bootcamp.domain.RecommendLog;
import com.dmc.bootcamp.dto.FoodDTO;
import com.dmc.bootcamp.repository.FoodRepository;
import com.dmc.bootcamp.repository.RecommendLogRepository;
import com.dmc.bootcamp.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class FoodService {
    //쿼리
    @Autowired
    private final FoodRepository foodRepository;
    @Autowired
    private UserController userController;

    public List<Food> getAllFood(){
        List<Food> foodList= foodRepository.findAll();
        return foodList;
    }

    public List<Food> getRecommendedMeal() {
        List<Food> recommendedMeal = new ArrayList<>();

        // 밥 추천
        foodRepository.findRandomFoodByPrefixesAndNutrients().ifPresent(recommendedMeal::add);

        // 국 추천
        foodRepository.findRandomSoupByPrefixesAndNutrients().ifPresent(recommendedMeal::add);

        // 반찬 추천 - 나물, 무침류 2개
        for (int i = 0; i < 2; i++) {
            foodRepository.findRandomNamulMoochimByNutrients().ifPresent(recommendedMeal::add);
        }

        // 반찬 추천 - 찜, 구이류 1개
        foodRepository.findRandomJjimGuiByNutrients().ifPresent(recommendedMeal::add);

        return recommendedMeal;
    }

<<<<<<< HEAD
=======
//    public FoodDTO findFoodById(String foodId) {
//        Optional<Food> food = foodRepository.findById(foodId);
//        if (food.isPresent()) {
//            return convertToDTO(food.get());
//        }
//        throw new RuntimeException("Food not found with ID: " + foodId);
//    }
//
//    private FoodDTO convertToDTO(Food food) {
//        FoodDTO dto = new FoodDTO();
//        dto.setFoodId(food.getFoodId());
//        dto.setFoodName(food.getFoodName());
//        dto.setServingSize(food.getServingSize());
//        dto.setCalories(food.getCalories());
//        dto.setCarbohydrate(food.getCarbohydrate());
//        dto.setProtein(food.getProtein());
//        dto.setFat(food.getFat());
//        dto.setSodium(food.getSodium());
//        dto.setSugar(food.getSugar());
//        return dto;
//    }
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608

    //반찬 추천
    public Food getBanchan(){
        Food bachan = foodRepository.findRandomNamulMoochimByNutrients().orElseThrow(()-> new IllegalArgumentException("반찬 없다"));
        return  bachan;

    }
    //2번 반찬 구현
    public  Food getBanchan2(){
        Food banchan2= foodRepository.findRandomJjimGuiByNutrients().orElseThrow(()-> new IllegalArgumentException("no banchan "));
        return banchan2;
    }
    //국 추천
    public Food getSoup(){
        Food soup= foodRepository.findRandomSoupByPrefixesAndNutrients().orElseThrow(()-> new IllegalArgumentException("no soup"));
        return  soup;
    }

    //밥 추천
    public  Food getRice(){
        Food rice= foodRepository.findRandomFoodByPrefixesAndNutrients().orElseThrow(()->new IllegalArgumentException("no rice"));
        return rice;
    }


    //환자 식단 추전
    public Food getBanchanForPatient(){
        Food banchanForPatient = foodRepository.findRandomNamulMoochimForPatient().orElseThrow(()-> new IllegalArgumentException("no banchan1 namul "));
        return banchanForPatient;
    }

    public Food getBanchan2ForPatient(){
        Food banchan2ForPatient = foodRepository.findRandomJjimGuiForPatient().orElseThrow(()-> new IllegalArgumentException("no banchan2 jjim"));
        return banchan2ForPatient;
    }

    public Food getSoupForPatient(){
        Food soupForPatient = foodRepository.findRandomSoupForPatient().orElseThrow(()-> new IllegalArgumentException("no soup"));
        return soupForPatient;
    }

    public Food getRiceForPatient(){
        Food riceForPatient = foodRepository.findRandomRiceForPatient().orElseThrow(()-> new IllegalArgumentException("no rice"));
        return riceForPatient;
    }


    private final UserRepository userRepository;


    public  List<Food> getMeal(String userId){
        AppUser user=userRepository.findUserByUserId(userId);
        if(user == null){
            throw new IllegalArgumentException("user not found");
        }
        List<Food> meal= new ArrayList<>();
        //비환자
        if(user.getDiseaseInfo()== null){
            meal.add(getRice());
            meal.add(getSoup());
            meal.add(getBanchan());
            meal.add(getBanchan2());

        }//환자
        if (user.getDiseaseInfo()!= null){
            meal.add(getRiceForPatient());
            meal.add(getSoupForPatient());
            meal.add(getBanchanForPatient());
            meal.add(getBanchan2ForPatient());
        }
        return meal;
    }
<<<<<<< HEAD

    public List<Food> getFoodsByRecommendId(Long recommendId) {
        return foodRepository.findFoodsByRecommendId(recommendId);
    }


=======
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
}
