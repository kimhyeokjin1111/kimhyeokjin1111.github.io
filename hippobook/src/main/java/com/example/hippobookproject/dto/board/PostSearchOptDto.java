package com.example.hippobookproject.dto.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class PostSearchOptDto {
    private String type;
    private String keyword;
    private String orderType;
}
