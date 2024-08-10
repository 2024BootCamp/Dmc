package com.dmc.bootcamp.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
@Table(name = "health_status")
public class HealthStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long statusId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    @JsonBackReference
    private AppUser appUser;

    @Column(name = "status_time")
    private LocalDateTime statusTime;

    @Column(name = "high_blood")
    private float highBlood;

    @Column(name = "low_blood")
    private float lowBlood;

    @Column(name = "empty_sugar")
    private float emptySugar;

    @Column(name = "full_sugar")
    private float fullSugar;

    @Builder
    public HealthStatus(float highBlood,float lowBlood,float emptySugar,float fullSugar,AppUser user){
        this.highBlood=highBlood;
        this.lowBlood=lowBlood;
        this.emptySugar=emptySugar;
        this.fullSugar=fullSugar;
        this.appUser=user;
    }

    @PrePersist
    protected void onCreate() {
        this.statusTime = LocalDateTime.now();
    }

    public void update(float highBlood,float lowBlood,float emptySugar,float fullSugar){
        this.highBlood=highBlood;
        this.lowBlood=lowBlood;
        this.emptySugar=emptySugar;
        this.fullSugar=fullSugar;
    }
}
