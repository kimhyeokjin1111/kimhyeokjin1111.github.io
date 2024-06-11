package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultNoticeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
class AdministratorHeaderMapperTest {
    @Autowired
    AdministratorHeaderMapper administratorHeaderMapper;

    @Test
    void selectDeclAll() {
        List<ResultNoticeDto> resultNoticeDtos = administratorHeaderMapper.selectDeclAll();
        assertThat(resultNoticeDtos)
                .hasSize(41);
    }

    @Test
    void selectStickerAll() {
        List<ResultNoticeDto> resultNoticeDtos = administratorHeaderMapper.selectStickerAll();
        assertThat(resultNoticeDtos)
                .hasSize(1);
    }

    @Test
    void selectNoticeAll() {
        List<ResultNoticeDto> resultNoticeDtos = administratorHeaderMapper.selectNoticeAll();
        assertThat(resultNoticeDtos)
                .hasSize(42);
    }

    @Test
    void updateStickerByIds(){
        List<Integer> integers = List.of(1);

        administratorHeaderMapper.updateStickerByIds(integers);
    }
}