package com.dmc.bootcamp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "recommend_log")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class RecommendLog {

    @Id
    @GeneratedValue
    private Long recommendId;

    @Column(name = "recom_time")
    private LocalDateTime recomTime;

    @ManyToMany
    @JoinTable(name = "recommendlog_food",joinColumns = @JoinColumn(name = "recommendId"),
    inverseJoinColumns = @JoinColumn(name = "food_id"))
    private List<Food> foods;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    @JsonBackReference
    private AppUser appUser;
}
