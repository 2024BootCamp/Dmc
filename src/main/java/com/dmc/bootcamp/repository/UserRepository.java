package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,String> {
    AppUser findUserByUserId(String userId);

    AppUser findByUserId(String userId);

}
