package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultStickerDto;
import com.example.hippobookproject.dto.administrator.SelectStickerDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdministratorStickerMapper {
    List<ResultStickerDto> selectStickerReqList(@Param("selectSticker")SelectStickerDto selectStickerDto,
                                                @Param("criteria")AdminUserCriteria criteria);

    int selectFollowReqTotal(@Param("selectSticker") SelectStickerDto selectStickerDto);

    void updateUserStickerCheck(List<Integer> idList);
}
