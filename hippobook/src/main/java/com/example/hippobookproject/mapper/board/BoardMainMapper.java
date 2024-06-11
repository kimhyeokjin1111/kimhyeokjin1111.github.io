package com.example.hippobookproject.mapper.board;

import com.example.hippobookproject.dto.board.PostSearchOptDto;
import com.example.hippobookproject.dto.board.PostSearchResultDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMainMapper {
    List<PostSearchResultDto> selectDealPost(@Param("searchOpt") PostSearchOptDto postSearchOptDto,
                                             @Param("criteria")AdminUserCriteria criteria);
    List<PostSearchResultDto> selectBoardPost(@Param("searchOpt")PostSearchOptDto postSearchOptDto,
                                              @Param("criteria")AdminUserCriteria criteria);
    List<PostSearchResultDto> selectNovelPost(@Param("searchOpt")PostSearchOptDto postSearchOptDto,
                                              @Param("criteria")AdminUserCriteria criteria);
    List<PostSearchResultDto> selectClaimPost(@Param("searchOpt")PostSearchOptDto postSearchOptDto,
                                              @Param("criteria")AdminUserCriteria criteria);

    int selectDeclPostTotal(@Param("searchOpt")PostSearchOptDto postSearchOptDto);
    int selectBoardPostTotal(@Param("searchOpt")PostSearchOptDto postSearchOptDto);
    int selectNovelPostTotal(@Param("searchOpt")PostSearchOptDto postSearchOptDto);
    int selectClaimPostTotal(@Param("searchOpt")PostSearchOptDto postSearchOptDto);
}
