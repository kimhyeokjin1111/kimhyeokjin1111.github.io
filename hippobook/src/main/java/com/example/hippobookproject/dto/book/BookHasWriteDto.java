package com.example.hippobookproject.dto.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookHasWriteDto {
    private Long bookcaseId;
    private Long bookId;
    private Long userId;
}
