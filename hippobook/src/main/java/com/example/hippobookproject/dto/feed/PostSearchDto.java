package com.example.hippobookproject.dto.feed;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
@NoArgsConstructor
public class PostSearchDto {
    private String cate;
    private String keyword;
}
