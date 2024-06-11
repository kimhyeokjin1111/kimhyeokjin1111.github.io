package com.example.hippobookproject.dto.Categorie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookDto {
    private Long bookId;
    private String bookName;
    private String bookWriter;
    private Long publisherId;
    private Long bookDate;
}

