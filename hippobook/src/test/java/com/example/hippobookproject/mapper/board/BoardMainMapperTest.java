package com.example.hippobookproject.mapper.board;

import com.example.hippobookproject.dto.board.PostSearchOptDto;
import com.example.hippobookproject.dto.board.PostSearchResultDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class BoardMainMapperTest {
    @Autowired
    BoardMainMapper boardMainMapper;

    PostSearchOptDto postSearchOptDto;
    AdminUserCriteria criteria;

    @BeforeEach
    void setUp() {
        postSearchOptDto = new PostSearchOptDto();
//        postSearchOptDto.setType("writer");
//        postSearchOptDto.setKeyword("Nickname");

        criteria = new AdminUserCriteria();
        criteria.setAmount(10);
        criteria.setPage(1);
    }

    @Test
    void selectDealPost() {
        List<PostSearchResultDto> postSearchResultDtos = boardMainMapper.selectDealPost(postSearchOptDto, criteria);
        assertThat(postSearchResultDtos)
                .hasSize(1)
                .extracting("postTitle")
                .contains("deal title");
    }

    @Test
    void selectDeclPostTotal(){
        int i = boardMainMapper.selectBoardPostTotal(postSearchOptDto);
        assertThat(i).isEqualTo(4);
    }

}