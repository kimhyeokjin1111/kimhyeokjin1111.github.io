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
public class AladinItemDto {
    private String title;
    private String link;
    private String author;
    private LocalDate pubDate;
    private String description;
    private String cover;
    private String isbn;
    private String categoryName;
    private String publisher;
}
