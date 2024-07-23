package com.dmc.bootcamp.dto.response;

import com.dmc.bootcamp.domain.AppUser;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserResponse {
    private String userId;
    private String password;
    private String userName;
    private Character gender;
    private LocalDate birthday;
    private String diseaseInfo;
    private float height;
    private float weight;
    private  String address;

    public UserResponse(AppUser appUser){
        this.userId= appUser.getUserId();
        this.userName= appUser.getUserName();
        this.password= appUser.getPassword();
        this.gender= appUser.getGender();
        this.birthday= appUser.getBirthday();
        this.diseaseInfo= appUser.getDiseaseInfo();
        this.height= appUser.getHeight();
        this.weight= appUser.getWeight();
        this.address= appUser.getAddress();
    }
}
