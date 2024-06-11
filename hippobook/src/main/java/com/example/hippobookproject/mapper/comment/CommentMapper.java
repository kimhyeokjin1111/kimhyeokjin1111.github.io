package com.example.hippobookproject.mapper.comment;

import com.example.hippobookproject.dto.comment.CommentReadDto;
import com.example.hippobookproject.dto.comment.CommentWriteDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    void insertDealComment(CommentWriteDto commentWriteDto);
    void insertBoardComment(CommentWriteDto commentWriteDto);
    void insertNovelComment(CommentWriteDto commentWriteDto);
    void insertClaimComment(CommentWriteDto commentWriteDto);
    void insertBookComment(CommentWriteDto commentWriteDto);

    List<CommentReadDto> selectDealComment(@Param("criteria") AdminUserCriteria criteria,
                                           Long postId);
    List<CommentReadDto> selectBoardComment(@Param("criteria") AdminUserCriteria criteria,
                                           Long postId);
    List<CommentReadDto> selectNovelComment(@Param("criteria") AdminUserCriteria criteria,
                                           Long postId);
    List<CommentReadDto> selectClaimComment(@Param("criteria") AdminUserCriteria criteria,
                                           Long postId);
    List<CommentReadDto> selectBookComment(@Param("criteria") AdminUserCriteria criteria,
                                           Long postId);

    int selectDealCommentTotal(Long postId);
    int selectBoardCommentTotal(Long postId);
    int selectNovelCommentTotal(Long postId);
    int selectClaimCommentTotal(Long postId);
    int selectBookCommentTotal(Long postId);
}
