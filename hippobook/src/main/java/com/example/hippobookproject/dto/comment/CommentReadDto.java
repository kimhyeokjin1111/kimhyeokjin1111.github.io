package com.example.hippobookproject.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@Setter
@NoArgsConstructor
public class CommentReadDto {
//    DEAL_COMMENT_ID comment_id, DEAL_COMMENT_CONTENT comment_content,
//    DEAL_COMMENT_CREATE comment_date, DC.USER_ID, USER_NICKNAME, DEAL_ID post_id
    private Long commentId;
    private String commentContent;
    private String commentDate;
    private Long userId;
    private String userNickname;
    private Long postId;

    public void setCommentDate(LocalDateTime commentDate){
        this.commentDate = commentDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss"));
    }
}
