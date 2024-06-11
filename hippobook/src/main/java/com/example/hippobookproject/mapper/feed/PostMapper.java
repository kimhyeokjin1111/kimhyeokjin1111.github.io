package com.example.hippobookproject.mapper.feed;

import com.example.hippobookproject.dto.feed.PostBookDto;
import com.example.hippobookproject.dto.feed.PostSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostBookDto> selectAll();
    List<PostBookDto> selectByKeyword(PostSearchDto postSearchDto);
}
