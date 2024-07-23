package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.dto.request.UserRequest;
import com.dmc.bootcamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public AppUser save(UserRequest request){
        return userRepository.save(request.toEntity());
    }

    public List<AppUser> getAllUser(){
        return userRepository.findAll();
    }

    public AppUser findById(String userId){
        return userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("not found"+userId));
    }

    public void  delete(String userId){
        AppUser appUser = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("not found"+ userId));
        userRepository.delete(appUser);
    }
}
