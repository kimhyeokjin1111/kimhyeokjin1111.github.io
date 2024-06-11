package com.example.hippobookproject.mapper.feed;

import com.example.hippobookproject.dto.feed.CardDto;
import com.example.hippobookproject.dto.feed.FollowDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class FeedMapperTest {
    @Autowired
    FeedMapper feedMapper;
    CardDto cardDto;
    FollowDto followDto;

    @Test
    void selectAll() {
        // given
        // when
        List<CardDto> feedList = feedMapper.selectAll(1L);
        // then
        Assertions.assertThat(feedList).isNotEmpty();

        System.out.println("feedList = " + feedList);
    }

    @Test
    void insertFollow(){
        followDto = new FollowDto();
        followDto.setFollowTo(1L);
        followDto.setFollowFrom(1L);
        feedMapper.insertFollow(followDto);
    }

    @Test
    void deleteFollow(){
        followDto = new FollowDto();
        followDto.setFollowTo(1L);
        System.out.println("followTo = " + followDto.getFollowTo());
//        feedMapper.deleteFollow(followDto.getFollowTo());

    }
}