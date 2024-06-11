package com.example.hippobookproject.api.comment;

import com.example.hippobookproject.dto.comment.CommentReadDto;
import com.example.hippobookproject.dto.comment.CommentWriteDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.dto.page.MessageSlice;
import com.example.hippobookproject.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentApi {
    private final CommentService commentService;

    @PostMapping("/v1/{type}/post")
    public void registerComment(@PathVariable("type") String commentType,
                             @RequestBody CommentWriteDto commentWriteDto){
        commentService.registerComment(commentType, commentWriteDto);
    }

    @GetMapping("/v1/{type}/post/comments")
    public MessageSlice<CommentReadDto> searchComment(@PathVariable("type") String commentType,
                                                      Long postId,
                                                      AdminUserCriteria criteria){
        log.info("commentType = " + commentType + ", postId = " + postId);
        return commentService.findComment(commentType, postId, criteria);
    }

    @GetMapping("/v1/{type}/post/comment/count")
    public int searchComment(@PathVariable("type") String postType,
                                                      Long postId){
        return commentService.findCommentTotal(postType, postId);
    }
}
