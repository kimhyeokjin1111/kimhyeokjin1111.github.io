package com.example.hippobookproject.mapper.board;

import com.example.hippobookproject.dto.board.PostSearchResultDto;
import com.example.hippobookproject.dto.board.PostViewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface BoardMapper {
    PostSearchResultDto selectDeclById(Long postId);
    PostSearchResultDto selectBoardById(Long postId);
    PostSearchResultDto selectNovelById(Long postId);
    PostSearchResultDto selectClaimById(Long postId);

    void insertDealView(PostViewDto postViewDto);
    void insertBoardView(PostViewDto postViewDto);
    void insertNovelView(PostViewDto postViewDto);
    void insertClaimView(PostViewDto postViewDto);

    int selectDealView(PostViewDto postViewDto);
    int selectBoardView(PostViewDto postViewDto);
    int selectNovelView(PostViewDto postViewDto);
    int selectClaimView(PostViewDto postViewDto);
}
