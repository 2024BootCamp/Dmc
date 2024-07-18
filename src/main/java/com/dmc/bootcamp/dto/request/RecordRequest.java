package com.dmc.bootcamp.dto.request;

import com.dmc.bootcamp.domain.Record;
import com.dmc.bootcamp.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecordRequest {
    private String image;
    private String content;
    private  float score;
    private String userId;

    public Record toEntity(User user){
        return Record.builder()
                .content(content)
                .image(image)
                .score(score)
                .user(user)
                .build();
    }

}
