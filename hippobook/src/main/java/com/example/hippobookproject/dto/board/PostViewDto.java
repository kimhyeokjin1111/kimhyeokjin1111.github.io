package com.example.hippobookproject.dto.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostViewDto {
    private Long postId;
    private Long userId;
}
