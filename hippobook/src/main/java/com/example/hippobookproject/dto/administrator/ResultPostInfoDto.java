package com.example.hippobookproject.dto.administrator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
@NoArgsConstructor
public class ResultPostInfoDto {
//    DEAL_ID, DEAL_TITLE, DEAL_CONTENT, DEAL_DATE, U.USER_NICKNAME
    private Long postId;
    private String postTitle;
    private String postContent;
    private LocalDate postDate;
    private String nickname;
    private String cate;
}
