package com.example.hippobookproject.mapper.like;

import com.example.hippobookproject.dto.like.PostLikeWriteDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LikeMapperTest {

    @Autowired
    LikeMapper likeMapper;

    PostLikeWriteDto postLikeWriteDto;
    @BeforeEach
    void setUp() {
        postLikeWriteDto = new PostLikeWriteDto();
        postLikeWriteDto.setUserId(1L);
        postLikeWriteDto.setPostId(6L);
    }
    @Test
    void insertDealLike() {
        likeMapper.insertDealLike(postLikeWriteDto);
    }
}