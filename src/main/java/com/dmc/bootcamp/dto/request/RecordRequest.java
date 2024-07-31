package com.dmc.bootcamp.dto.request;


import com.dmc.bootcamp.domain.Record;
import com.dmc.bootcamp.domain.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Map;

@Getter
@Setter
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
