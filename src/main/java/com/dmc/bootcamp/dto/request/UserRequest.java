package com.dmc.bootcamp.dto.request;

import com.dmc.bootcamp.domain.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
=======
import lombok.Setter;
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
<<<<<<< HEAD
=======
@Setter
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
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
