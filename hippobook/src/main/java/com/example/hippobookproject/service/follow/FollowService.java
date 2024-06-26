package com.example.hippobookproject.service.follow;

import com.example.hippobookproject.mapper.follow.FollowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FollowService {
    private final FollowMapper followMapper;
}
