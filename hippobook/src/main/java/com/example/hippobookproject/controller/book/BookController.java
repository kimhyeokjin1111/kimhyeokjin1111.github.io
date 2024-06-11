package com.example.hippobookproject.controller.book;

import com.example.hippobookproject.dto.book.BookInfoDto;
import com.example.hippobookproject.service.book.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/info")
    public String bookInfo(Model model, Long bookId,@SessionAttribute(value = "userId", required = false) Long userId){
        log.info("bookId = " + bookId);
        BookInfoDto bookInfo = bookService.findBookInfo(bookId);
        int bookHas = 0;
        if(userId != null){
            bookHas = bookService.findBookHas(bookId, userId);
        }

        model.addAttribute("bookInfo", bookInfo);
        model.addAttribute("bookHas", bookHas);
        model.addAttribute("userId", userId);
        return "book/book_info_page";
    }

}

