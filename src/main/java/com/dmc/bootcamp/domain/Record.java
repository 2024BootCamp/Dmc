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
    private User user;


    @Column(name = "score")
    private float score;

    @Builder
    public Record(String image, String content,float score,User user){
        this.content=content;
        this.image=image;
        this.score=score;
        this.user=user;
    }

    @PrePersist
    protected void onCreate() {
        this.recordDate = LocalDateTime.now();
    }

    public void update(String image, String content,float score){
        this.content=content;
        this.image=image;
        this.score=score;
    }
}
