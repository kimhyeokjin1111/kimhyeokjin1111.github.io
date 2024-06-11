package com.example.hippobookproject.dto.feed;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
@NoArgsConstructor
public class PostBookDto {
    private Long bookId;
    private String bookName;
    private String bookWriter;
    private LocalDate bookDate;
    private Long publisherId;
}
