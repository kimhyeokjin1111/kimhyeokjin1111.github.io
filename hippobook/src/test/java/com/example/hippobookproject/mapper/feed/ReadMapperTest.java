package com.example.hippobookproject.mapper.feed;

import com.example.hippobookproject.dto.feed.CardDto;
import com.example.hippobookproject.dto.feed.FollowDto;
import com.example.hippobookproject.dto.feed.ReadCardDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ReadMapperTest {
    @Autowired
    ReadMapper readMapper;
    ReadCardDto readCardDto;
    FollowDto followDto;
    @Test
    void selectAll() {
        List<ReadCardDto> readList = readMapper.selectAll(1L);
        // then
        Assertions.assertThat(readList).isNotEmpty();

        System.out.println("readList = " + readList);
    }

    @Test
    void insertFollow(){
        followDto = new FollowDto();
        followDto.setFollowTo(1L);
        followDto.setFollowFrom(1L);
        readMapper.insertFollow(followDto);
    }

    @Test
    void deleteFollow(){
        followDto = new FollowDto();
        followDto.setFollowTo(1L);
        System.out.println("followTo = " + followDto.getFollowTo());
//        feedMapper.deleteFollow(followDto.getFollowTo());

    }
}