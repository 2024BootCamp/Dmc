package com.dmc.bootcamp.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "food_data")
public class Food{
    @Id
    @Column(name = "food_id",updatable = false)
    private String foodId;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "serving_size")
    private String servingSize;

    @Column(name = "calories")
    private  float calories;

    @Column(name = "carbohydrate")
    private float carbohydrate;

    @Column(name = "protein")
    private  float protein;

    @Column(name = "fat")
    private float fat;

    @Column(name = "sodium")
    private  float sodium;

    @Column(name = "sugar")
    private float sugar;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "foods")
    private List<RecommendLog> recommendLogs;


}
