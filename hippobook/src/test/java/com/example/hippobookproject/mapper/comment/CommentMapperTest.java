package com.example.hippobookproject.mapper.comment;

import com.example.hippobookproject.dto.comment.CommentReadDto;
import com.example.hippobookproject.dto.comment.CommentWriteDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
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
class CommentMapperTest {

    @Autowired
    CommentMapper commentMapper;

    CommentWriteDto commentWriteDto;
    AdminUserCriteria criteria;
    @BeforeEach
    void setUp(){
        commentWriteDto = new CommentWriteDto();
        commentWriteDto.setCommentContent("test deal comment");
        commentWriteDto.setUserId(1L);
        commentWriteDto.setPostId(1L);

        criteria = new AdminUserCriteria();
        criteria.setPage(1);
        criteria.setAmount(3);
    }

    @Test
    void insertDealComment() {
        commentMapper.insertDealComment(commentWriteDto);
        List<CommentReadDto> commentReadDtos = commentMapper.selectDealComment(criteria,1L);

        assertThat(commentReadDtos)
                .hasSize(4)
                .extracting("userNickname")
                .contains("usernick");
    }
}