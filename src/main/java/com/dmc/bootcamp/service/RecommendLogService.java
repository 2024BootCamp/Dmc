package com.dmc.bootcamp.service;

import com.dmc.bootcamp.domain.RecommendLog;
import com.dmc.bootcamp.repository.RecommendLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendLogService {
    private final RecommendLogRepository recommendLogRepository;

}
