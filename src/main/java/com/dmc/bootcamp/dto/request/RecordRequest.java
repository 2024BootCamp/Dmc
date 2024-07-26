package com.dmc.bootcamp.dto.request;

import com.dmc.bootcamp.domain.Meal;
import com.dmc.bootcamp.domain.Record;
import com.dmc.bootcamp.domain.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecordRequest {

    private String image;
    private String content;
    private String userId;
    private Map<String, Float> listMeal;


    public Record toEntity(AppUser appUser){
        return Record.builder()
                .content(content)
                .image(image)
                .listMeal(listMeal)
                .appUser(appUser)
                .build();
    }

}
