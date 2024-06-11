package com.example.hippobookproject.service.feed;

import com.example.hippobookproject.dto.feed.CardDto;
import com.example.hippobookproject.dto.feed.FollowDto;
import com.example.hippobookproject.mapper.feed.FeedMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper feedMapper;

    public List<CardDto> selectAll(Long userId){
        return feedMapper.selectAll(userId);
    }

    public void insertFollow(FollowDto followDto){
        feedMapper.insertFollow(followDto);
    }

    public void deleteFollow(FollowDto followDto){
        feedMapper.deleteFollow(followDto);
    }
}
