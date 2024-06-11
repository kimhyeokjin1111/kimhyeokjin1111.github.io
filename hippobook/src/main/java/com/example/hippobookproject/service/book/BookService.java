package com.example.hippobookproject.service.book;

import com.example.hippobookproject.dto.book.AladinApiDto;
import com.example.hippobookproject.dto.book.BookCommentWriteDto;
import com.example.hippobookproject.dto.book.BookHasWriteDto;
import com.example.hippobookproject.dto.book.BookInfoDto;
import com.example.hippobookproject.dto.recommend.RecommendDto;
import com.example.hippobookproject.mapper.book.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;
    private final BookSearchMapper bookSearchMapper;

    @Value("${api.key.aladin}")
    private String apiKey;

    public AladinApiDto findAllBook(int start){
        String baseUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx";
        String queryType = "ItemNewAll";
        String searchTarget = "Book";
        String output = "js";
        String version = "20131101";
//        int searchCategoryId =
//        int start = 1;
        int maxResults = 50;

        String url = baseUrl + "?ttbkey=" + apiKey +
                "&QueryType=" + queryType +
                "&SearchTarget=" + searchTarget +
                "&output=" + output +
                "&version=" + version +
                "&Start=" + start +
                "&MaxResults=" + maxResults;
        log.info("url : {}", url);


        WebClient webClient = WebClient.builder().build();
        AladinApiDto result = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(AladinApiDto.class)
                .block();

//        System.out.println("result = " + result);
        return result;
    }

    public BookInfoDto findBookInfo(Long bookId){
        BookInfoDto bookInfoDto = bookMapper.selectBookInfo(bookId).orElseThrow(() -> new IllegalStateException("해당 책 정보가 존재하지 않습니다."));
        bookInfoDto.setCover(bookInfoDto.getCover().replace("sum", ""));
        return bookInfoDto;
    }

    public void registerBookHas(BookHasWriteDto bookHasWriteDto){
        bookMapper.insertBookHas(bookHasWriteDto);
    }

    public int findBookHas(Long bookId , Long userId){
        return bookMapper.selectBookHas(bookId, userId);
    }

    public void registerBookComment(BookCommentWriteDto bookCommentWriteDto){
        bookMapper.insertBookComment(bookCommentWriteDto);
    }

    public List<BookInfoDto> findBookByKeyword(String keyword){
        return bookSearchMapper.selectBookByKeyword(keyword);
    }

    public void registerRecommend(String keyword){
        bookSearchMapper.insertRecommend(keyword);
    }

    public List<RecommendDto> findRecommend(){
        return bookSearchMapper.selectRecommend();
    }

    public int findBookCommentAll(Long bookId){
        return bookMapper.selectBookCommentAll(bookId);
    }

}
