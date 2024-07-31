package com.dmc.bootcamp.dto.request;

<<<<<<< HEAD
import com.dmc.bootcamp.domain.AppUser;
=======
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
import com.dmc.bootcamp.domain.HealthStatus;
import com.dmc.bootcamp.domain.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HealthStatusRequest {

    private  float highBlood;
    private float lowBlood;
    private float emptySugar;
    private float fullSugar;
    private String userId;

<<<<<<< HEAD
    public HealthStatus toEntity(AppUser user){
=======
    public HealthStatus toEntity(AppUser appUser){
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
        return HealthStatus.builder()
                .highBlood(highBlood)
                .lowBlood(lowBlood)
                .emptySugar(emptySugar)
                .fullSugar(fullSugar)
<<<<<<< HEAD
                .user(user)
=======
                .appUser(appUser)
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
                .build();

    }
}
