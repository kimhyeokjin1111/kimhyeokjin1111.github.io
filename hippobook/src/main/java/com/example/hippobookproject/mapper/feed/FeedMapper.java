package com.example.hippobookproject.mapper.feed;

import com.example.hippobookproject.dto.feed.CardDto;
import com.example.hippobookproject.dto.feed.FollowDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    List<CardDto> selectAll(Long userId);
    void insertFollow(FollowDto followDto);
    void deleteFollow(FollowDto followDto);

}
