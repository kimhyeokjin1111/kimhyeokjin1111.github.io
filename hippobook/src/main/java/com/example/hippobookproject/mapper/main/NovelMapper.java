package com.example.hippobookproject.mapper.main;

import com.example.hippobookproject.dto.main.NovelListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface NovelMapper {
    List<NovelListDto> selectAll();


}
