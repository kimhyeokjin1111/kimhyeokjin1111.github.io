package com.example.hippobookproject.service.recommend;

import com.example.hippobookproject.mapper.recommend.RecommendMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RecommendService {
    private final RecommendMapper recommendMapper;
}
