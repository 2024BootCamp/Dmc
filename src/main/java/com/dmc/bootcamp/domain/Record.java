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
    @CollectionTable(name = "record_food", joinColumns = @JoinColumn(name = "record_id"))
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

}
