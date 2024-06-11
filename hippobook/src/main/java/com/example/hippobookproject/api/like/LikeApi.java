package com.example.hippobookproject.api.like;

import com.example.hippobookproject.dto.like.PostLikeWriteDto;
import com.example.hippobookproject.service.like.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LikeApi {
    private final LikeService likeService;

    @PostMapping("/v1/{type}/post/like")
    public void registerPostLikeByType(@PathVariable("type") String postType,
                                 @RequestBody PostLikeWriteDto postLikeWriteDto){
        log.info("postType = " + postType + ", postLikeWriteDto = " + postLikeWriteDto);
        likeService.registerPostLike(postType, postLikeWriteDto);
    }

    @GetMapping("/v1/{type}/post/like")
    public int findPostLikeByType(@PathVariable("type") String postType,
                                  Long postId){
        log.info("postType = " + postType + ", postId = " + postId);
        return likeService.findPostLike(postType, postId);
    }
}
