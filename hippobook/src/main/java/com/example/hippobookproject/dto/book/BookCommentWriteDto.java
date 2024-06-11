package com.example.hippobookproject.dto.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookCommentWriteDto {
    private String bookCommentContent;
    private Long bookId;
    private Long userId;
}
