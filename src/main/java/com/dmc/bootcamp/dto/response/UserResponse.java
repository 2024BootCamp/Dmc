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

<<<<<<< HEAD
    public UserResponse(AppUser user){
        this.userId=user.getUserId();
        this.userName=user.getUserName();
        this.password=user.getPassword();
        this.gender=user.getGender();
        this.birthday=user.getBirthday();
        this.diseaseInfo=user.getDiseaseInfo();
        this.height=user.getHeight();
        this.weight=user.getWeight();
        this.address=user.getAddress();
=======
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
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
    }
}
