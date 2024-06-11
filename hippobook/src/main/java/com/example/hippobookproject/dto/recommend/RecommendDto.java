package com.example.hippobookproject.dto.recommend;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class RecommendDto {
    String keyword;
    int count;
}
