package com.dmc.bootcamp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "recommend_log")
@Setter
@EntityListeners(AuditingEntityListener.class)
public class RecommendLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendId;

    @Column(name = "recom_time")
    private LocalDateTime recomTime;

    @ManyToMany
    @JoinTable(name = "recom_food",joinColumns = @JoinColumn(name = "recommendId"),
    inverseJoinColumns = @JoinColumn(name = "food_id"))
    @JsonIgnore // 이 어노테이션으로 인해 foods 필드는 직렬화되지 않음
    private List<Food> foods;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    @JsonBackReference
    private AppUser appUser;

    public RecommendLog(){};

    @PrePersist
    protected void onCreate() {
        this.recomTime = LocalDateTime.now();
    }

    @Builder
    public RecommendLog( List<Food> foods,AppUser appUser) {
        this.foods=foods;
        this.appUser=appUser;
    }
}
