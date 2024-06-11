package com.example.hippobookproject.dto.Categorie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookCateDto {
    private Long bookCateId;
    private Long cateId;
    private Long bookId;
}
