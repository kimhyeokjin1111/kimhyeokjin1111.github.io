package com.example.hippobookproject.dto.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostSearchResultDto {
//    DEAL_ID, DEAL_TITLE, USER_ID, USER_NICKNAME,
//    LIKE_COUNT, DEAL_DATE, DEAL_VIEW
    private Long postId;
    private String postTitle;
    private String postContent;
    private Long userId;
    private String userNickname;
    private int likeCount;
    private LocalDate postDate;
    private int postView;
}
