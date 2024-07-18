package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.User;
import com.dmc.bootcamp.dto.request.UserRequest;
import com.dmc.bootcamp.dto.response.UserResponse;
import com.dmc.bootcamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(UserRequest request){
        return userRepository.save(request.toEntity());
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User findById(String userId){
        return userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("not found"+userId));
    }

    public void  delete(String userId){
        User user= userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("not found"+ userId));
        userRepository.delete(user);
    }
}
