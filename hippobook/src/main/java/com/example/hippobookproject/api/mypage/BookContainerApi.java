package com.example.hippobookproject.api.mypage;

import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.service.mypage.MypageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookContainerApi {
    private final MypageService mypageService;

    @DeleteMapping("/v1/containers/book/{bookHasId}")
    public void bookContainer(@PathVariable("bookHasId") Long bookHasId,
                                HttpSession session){
        log.info("bookHasId = {}",bookHasId);
        mypageService.removeBookContainer(bookHasId);

    }

    @PatchMapping("/v1/containers/book/{bestBookId}")
    public void modifyBestBook(@SessionAttribute(value = "userId", required = false) Long userId,
                               @PathVariable("bestBookId") Long bestBookId
                               ){
       // userId = 1L;
        BookContainerDto bookContainerDto = new BookContainerDto();
        bookContainerDto.setUserId(userId);
        bookContainerDto.setBookHasId(bestBookId);
        log.info("bookContainerDto={}",bookContainerDto);
        mypageService.modifyBestBook(bookContainerDto);
    }


    @PatchMapping("/v2/containers/book/{bookHasId}")
    public void modifyBookStatus(@PathVariable("bookHasId") Long bookHasId,
                               @RequestBody String bookHasPercent
    ){


        //bookHasId = 43L;

        BookContainerDto bookContainerDto = new BookContainerDto();
        bookContainerDto.setBookHasId(bookHasId);
        bookContainerDto.setBookHasPercent(bookHasPercent);
        log.info("bookContainerDto={}",bookContainerDto);
        mypageService.modifyBookStatus(bookContainerDto);

    }


    




}
