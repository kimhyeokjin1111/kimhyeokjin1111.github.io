package com.example.hippobookproject.service.comment;

import com.example.hippobookproject.dto.comment.CommentReadDto;
import com.example.hippobookproject.dto.comment.CommentWriteDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.dto.page.MessageSlice;
import com.example.hippobookproject.mapper.comment.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper commentMapper;

    public void registerComment(String commentType, CommentWriteDto commentWriteDto){
        switch (commentType){
            case "deal":
                commentMapper.insertDealComment(commentWriteDto);
                break;
            case "board":
                commentMapper.insertBoardComment(commentWriteDto);
                break;
            case "novel":
                commentMapper.insertNovelComment(commentWriteDto);
                break;
            case "claim":
                commentMapper.insertClaimComment(commentWriteDto);
                break;
            default:
                commentMapper.insertBookComment(commentWriteDto);
                break;
        }
    }

    public MessageSlice<CommentReadDto> findComment(String commentType, Long postId, AdminUserCriteria criteria){
        List<CommentReadDto> commentReadDtos;

        switch (commentType){
            case "deal":
                commentReadDtos = commentMapper.selectDealComment(criteria, postId);
                break;
            case "board":
                commentReadDtos = commentMapper.selectBoardComment(criteria, postId);
                break;
            case "novel":
                commentReadDtos = commentMapper.selectNovelComment(criteria, postId);
                break;
            case "claim":
                commentReadDtos = commentMapper.selectClaimComment(criteria, postId);
                break;
            default:
                commentReadDtos = commentMapper.selectBookComment(criteria, postId);
        }
        boolean hasNext = commentReadDtos.size() > criteria.getAmount();

        if(hasNext){
            commentReadDtos.remove(criteria.getAmount());
        }

        return new MessageSlice<>(hasNext, commentReadDtos);
    }

    public int findCommentTotal(String postType, Long postId){
        switch (postType){
            case "deal":
                return commentMapper.selectDealCommentTotal(postId);
            case "board":
                return commentMapper.selectBoardCommentTotal(postId);
            case "novel":
                return commentMapper.selectNovelCommentTotal(postId);
            case "claim":
                return commentMapper.selectClaimCommentTotal(postId);
            default:
                return commentMapper.selectBookCommentTotal(postId);
        }
    }
}
