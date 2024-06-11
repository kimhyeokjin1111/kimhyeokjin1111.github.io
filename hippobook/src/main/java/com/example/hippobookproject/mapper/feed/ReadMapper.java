package com.example.hippobookproject.mapper.feed;

import com.example.hippobookproject.dto.feed.FollowDto;
import com.example.hippobookproject.dto.feed.ReadCardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReadMapper {
    List<ReadCardDto> selectAll(Long userId);
    void insertFollow(FollowDto followDto);
    void deleteFollow(FollowDto followDto);
}
