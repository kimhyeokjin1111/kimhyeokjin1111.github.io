package com.example.hippobookproject.mapper.like;

import com.example.hippobookproject.dto.like.PostLikeWriteDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
    void insertDealLike(PostLikeWriteDto postLikeWriteDto);
    void insertBoardLike(PostLikeWriteDto postLikeWriteDto);
    void insertNovelLike(PostLikeWriteDto postLikeWriteDto);
    void insertClaimLike(PostLikeWriteDto postLikeWriteDto);

    int selectDealLike(Long postId);
    int selectBoardLike(Long postId);
    int selectNovelLike(Long postId);
    int selectClaimLike(Long postId);
}
