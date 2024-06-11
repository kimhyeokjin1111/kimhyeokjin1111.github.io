package com.example.hippobookproject.controller.categorie;

import com.example.hippobookproject.service.book.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/categorie")
@RequiredArgsConstructor
public class CategorieController {
    private final BookService bookService;

    @GetMapping("/Categoriepage")
    public String Categoriepage(){
        return "categorie/Categoriepage";
    }
    @GetMapping("/content")
    public String content(){
        return "categorie/content";
    }
    @GetMapping("/collection")
    public String collection(){
        return "categorie/collection";
    }
    @GetMapping("/writer")
    public String writer(){
        return "categorie/writer";
    }

}

