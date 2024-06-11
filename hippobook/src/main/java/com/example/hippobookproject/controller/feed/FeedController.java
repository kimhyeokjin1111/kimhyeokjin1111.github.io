package com.example.hippobookproject.controller.feed;

import com.example.hippobookproject.dto.feed.CardDto;
import com.example.hippobookproject.dto.feed.PostBookDto;
import com.example.hippobookproject.dto.feed.PostSearchDto;
import com.example.hippobookproject.dto.feed.ReadCardDto;
import com.example.hippobookproject.service.feed.FeedService;
import com.example.hippobookproject.service.feed.PostService;
import com.example.hippobookproject.service.feed.ReadService;
import com.example.hippobookproject.service.follow.FollowService;
import com.example.hippobookproject.service.recommend.RecommendService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {
    private final FeedService feedService;
    private final RecommendService recommendService;
    private final FollowService followService;
    private final ReadService readService;
    private final PostService postService;

    @GetMapping()
    public String feedPage(Model model, HttpSession session){
//        Long userId = (Long) session.getAttribute("userId");
        Long userId = 1L;
        List<CardDto> feedList = feedService.selectAll(userId);
        model.addAttribute("feedList", feedList);
        return "feed/feedpage";
    }

    @GetMapping("/oneline")
    public String onelinePage(){
        return "feed/onelinepage";
    }

    @GetMapping("/read")
    public String readPage(Model model, HttpSession httpSession){
 //        Long userId = (Long) session.getAttribute("userId");
        Long userId = 1L;
        List<ReadCardDto> readList = readService.selectAll(userId);

        System.out.println("readList = " + readList);

        model.addAttribute("readList", readList);
        return "feed/readpage";
    }
    @GetMapping("/postwrite")
    public String postwrite(PostSearchDto postSearchDto, Model model){
        List<PostBookDto> postList = postService.selectByKeyword(postSearchDto);
        model.addAttribute("postList", postList);

        return "feed/postwrite";
    }

    @GetMapping("/readwrite")
    public String readwrite(){
        return "feed/readwrite";
    }

    @GetMapping("/follow")
    public String followpage(){
        return "follow/followingpage";
    }
}
