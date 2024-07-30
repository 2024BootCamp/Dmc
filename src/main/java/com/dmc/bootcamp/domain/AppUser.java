package com.dmc.bootcamp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class AppUser {
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

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "appUser",fetch = FetchType.EAGER)
    private List<HealthStatus> healthStatuses;


    @OneToMany(mappedBy = "appUser",fetch = FetchType.EAGER)
    private  List<RecommendLog> recommendLogs;

    @OneToMany(mappedBy = "appUser",fetch = FetchType.LAZY)
    private List<Record> records;

    @Builder
    public AppUser(String userId, String userName, String password, Character gender, LocalDate birthday, String diseaseInfo, float height, float weight, String address){
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
