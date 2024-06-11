package com.example.hippobookproject.mapper.book;

import com.example.hippobookproject.dto.recommend.RecommendDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BookSearchMapperTest {

    @Autowired
    BookSearchMapper bookSearchMapper;

    @BeforeEach
    void setUp(){
    }

    @Test
    void insertRecommend() {
        bookSearchMapper.insertRecommend("어린");
        List<RecommendDto> recommendDtos = bookSearchMapper.selectRecommend();
        assertThat(recommendDtos)
                .extracting("keyword")
                .contains("어린");

    }

}