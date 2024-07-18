package com.dmc.bootcamp.controller;

import com.dmc.bootcamp.domain.User;
import com.dmc.bootcamp.dto.request.UserRequest;
import com.dmc.bootcamp.dto.response.UserResponse;
import com.dmc.bootcamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody UserRequest request){
        User savedUser= userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserResponse>> getUser(){
        List<UserResponse> list= userService.getAllUser().stream().map(UserResponse::new).toList();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserResponse> findUser(@PathVariable String userId){
        User user= userService.findById(userId);
        return ResponseEntity.ok().body(new UserResponse(user));
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }
}
