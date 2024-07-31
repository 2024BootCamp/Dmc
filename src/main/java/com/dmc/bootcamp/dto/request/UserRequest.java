package com.dmc.bootcamp.dto.request;

import com.dmc.bootcamp.domain.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
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

    public AppUser toEntity(){
        return AppUser.builder()
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
