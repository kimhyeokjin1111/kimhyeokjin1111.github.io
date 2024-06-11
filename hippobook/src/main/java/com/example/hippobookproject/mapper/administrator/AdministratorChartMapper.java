package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultChartAdminDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdministratorChartMapper {
    List<ResultChartAdminDto> selectVisitByRange(int term);
}
