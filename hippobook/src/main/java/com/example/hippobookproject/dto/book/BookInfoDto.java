package com.example.hippobookproject.dto.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookInfoDto {
//    B.BOOK_ID, BOOK_NAME, BOOK_WRITER, BOOK_DATE, LINK, DESCRIPTION,
//    COVER, PUBLISHER_ID PUB_NAME, ISBN, CATEGORY, BOOK_HAS_CNT
    private Long bookId;
    private String bookName;
    private String BookWriter;
    private LocalDate BookDate;
    private String link;
    private String description;
    private String cover;
    private String pubName;
    private String isbn;
    private String category;
    private int bookHasCnt;
}
