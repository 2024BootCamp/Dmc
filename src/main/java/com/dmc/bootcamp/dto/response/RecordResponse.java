package com.dmc.bootcamp.dto.response;

import com.dmc.bootcamp.domain.Record;
import lombok.Getter;

import java.util.Map;

@Getter
public class RecordResponse {
    private Long recordId;
    private String image;
    private String content;
    private String userId;
    private Map<String,Float> listFoods;

    public RecordResponse(Record record){
        this.recordId = record.getRecordId();
        this.image=record.getImage();
        this.content=record.getContent();
        this.userId=record.getAppUser().getUserId();
        this.listFoods=record.getListMeal();
    }

}
