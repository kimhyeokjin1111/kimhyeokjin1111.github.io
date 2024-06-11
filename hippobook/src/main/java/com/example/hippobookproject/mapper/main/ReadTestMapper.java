package com.example.hippobookproject.mapper.main;

import com.example.hippobookproject.dto.main.ReadListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReadTestMapper {
    List<ReadListDto> selectByContent();
}
