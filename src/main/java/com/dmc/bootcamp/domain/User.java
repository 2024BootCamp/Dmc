package com.dmc.bootcamp.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "disease_info")
    private String diseaseInfo;

    @Column(name = "height")
    private float height;

    @Column(name = "weight")
    private float weight;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<HealthStatus> healthStatuses;

    @Builder
    public User(String userId,String userName,String password,Character gender,LocalDate birthday,String diseaseInfo,float height,float weight,String address){
        this.userId=userId;
        this.password=password;
        this.userName=userName;
        this.gender=gender;
        this.birthday=birthday;
        this.diseaseInfo=diseaseInfo;
        this.height=height;
        this.weight=weight;
        this.address=address;
    }

  
}
