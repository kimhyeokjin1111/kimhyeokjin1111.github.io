package com.example.hippobookproject.api.feed;

import com.example.hippobookproject.dto.feed.FollowDto;
import com.example.hippobookproject.dto.feed.PostSearchDto;
import com.example.hippobookproject.service.feed.FeedService;
import com.example.hippobookproject.service.feed.PostService;
import com.example.hippobookproject.service.feed.ReadService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FeedApi {
    private final PostService postService;

    @PostMapping("/v1/search")
    public void search(@RequestBody PostSearchDto postSearchDto, HttpSession session){
        log.info("postSearchDto = " + postSearchDto);
        postService.selectByKeyword(postSearchDto);
    }
}
