package com.example.hippobookproject.mapper.main;

import com.example.hippobookproject.dto.main.DealListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DealMapper {
    List<DealListDto> selectByTitle();
}
