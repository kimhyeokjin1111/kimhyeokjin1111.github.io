package com.example.hippobookproject.api.book;

import com.example.hippobookproject.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AladinApi {
    private final BookService bookService;

//    @GetMapping("/api")
//    public void apiTest(){
//        bookService.findAllBook();
//    }
}
