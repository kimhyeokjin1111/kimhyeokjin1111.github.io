package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultNoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdministratorHeaderMapper {
    List<ResultNoticeDto> selectDeclAll();
    List<ResultNoticeDto> selectStickerAll();
    List<ResultNoticeDto> selectNoticeAll();

    void updatePDeclByIds(List<Integer> idList);
    void updateCDeclByIds(List<Integer> idList);
    void updateFDeclByIds(List<Integer> idList);
    void updateStickerByIds(List<Integer> idList);
}
