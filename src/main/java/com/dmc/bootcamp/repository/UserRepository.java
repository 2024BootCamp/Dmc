package com.dmc.bootcamp.repository;

import com.dmc.bootcamp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findUserByUserId(String userId);
}
