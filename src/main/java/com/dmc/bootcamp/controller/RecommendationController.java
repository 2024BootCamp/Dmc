package com.dmc.bootcamp.controller;

import com.dmc.bootcamp.domain.AppUser;
import com.dmc.bootcamp.dto.FoodDTO;

import com.dmc.bootcamp.dto.response.RecommendationResponse;

import com.dmc.bootcamp.service.RecommendLogService;
import com.dmc.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {
    @Autowired
    private RecommendLogService recommendLogService;

    @Autowired
    private UserService pserService; // 필요 시



}
