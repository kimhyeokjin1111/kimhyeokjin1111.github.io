package com.example.hippobookproject.mapper.feed;

import com.example.hippobookproject.dto.feed.PostBookDto;
import com.example.hippobookproject.dto.feed.PostSearchDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostMapperTest {
    @Autowired
    PostMapper postMapper;
    PostSearchDto postSearchDto;

//    @Test
//    void selectAll() {
//        List<PostBookDto> PostList = postMapper.selectAll();
//        System.out.println("PostList = " + PostList);
//    }

    @Test
    void selectByKeyword(){
        PostSearchDto searchDto = new PostSearchDto();
        searchDto.setCate("bookName");
        searchDto.setKeyword("a");

        List<PostBookDto> bookList = postMapper.selectByKeyword(searchDto);
        System.out.println("bookList = " + bookList);
    }
}