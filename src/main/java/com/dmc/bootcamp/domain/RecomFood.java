package com.dmc.bootcamp.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "recom_food", schema = "dmc")
public class RecomFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recommend_id")
    private Long recommendId;

    @Column(name = "food_id")
    private String foodId;

    @ManyToOne
    @JoinColumn(name = "recommend_id", insertable = false, updatable = false)
    private RecommendLog recommendLog;

    @ManyToOne
    @JoinColumn(name = "food_id", insertable = false, updatable = false)
    private Food food;

    // getters and setters
}
