package com.example.hippobookproject.mapper.book;

import com.example.hippobookproject.dto.book.BookInfoDto;
import com.example.hippobookproject.dto.recommend.RecommendDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookSearchMapper {
    List<BookInfoDto> selectBookByKeyword(String keyword);

    void insertRecommend(String keyword);

    List<RecommendDto> selectRecommend();
}
