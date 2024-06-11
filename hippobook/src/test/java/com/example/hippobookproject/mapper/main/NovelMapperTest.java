package com.example.hippobookproject.mapper.main;

import com.example.hippobookproject.dto.main.NovelListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class NovelMapperTest {
    @Autowired
    NovelMapper novelMapper;

    @Test
    void selectAll() {

        // given
        // when
        List<NovelListDto> novelList = novelMapper.selectAll();
        // then
        assertThat(novelList).isNotEmpty();
    }
}