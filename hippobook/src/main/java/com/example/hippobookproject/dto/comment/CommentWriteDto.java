package com.example.hippobookproject.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommentWriteDto {
    private String commentContent;
    private Long userId;
    private Long postId;
}
