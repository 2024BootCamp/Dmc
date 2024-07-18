package com.dmc.bootcamp.dto.request;

import com.dmc.bootcamp.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserRequest {
    private String userId;
    private String password;
    private String userName;
    private Character gender;
    private LocalDate birthday;
    private String diseaseInfo;
    private float height;
    private float weight;
    private  String address;

    public User toEntity(){
        return User.builder()
                .userId(userId)
                .userName(userName)
                .password(password)
                .gender(gender)
                .birthday(birthday)
                .diseaseInfo(diseaseInfo)
                .height(height)
                .weight(weight)
                .address(address)
                .build();
    }
}
