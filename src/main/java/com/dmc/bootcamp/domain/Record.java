package com.dmc.bootcamp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
@Setter
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recordId;

    @Column(name = "record_date")
    private LocalDateTime recordDate;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    @JsonBackReference
    private AppUser appUser;

    @ElementCollection
    @CollectionTable(name = "meal", joinColumns = @JoinColumn(name = "record_id"))
    @MapKeyColumn(name = "food_name")
    @Column(name = "quantity")
    private Map<String, Float> listMeal;


    @Builder
    public Record(String image, String content, AppUser appUser,Map<String, Float> listMeal) {
        this.content = content;
        this.image = image;
        this.appUser = appUser;
        this.listMeal = listMeal;
    }

    @PrePersist
    protected void onCreate() {
        this.recordDate = LocalDateTime.now();
    }

    public void update(String image, String content) {
        this.content = content;
        this.image = image;
    }

    //유저의 맞춘 식단을 추천하고 나서 바로 RecordRepository를 이용하여 record 테이블에 저장
    //식단 추천 서비스 클라스에서 총합 kcal,sodium,sugar 등을 계산하고 기준을 지정
}
