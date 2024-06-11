package com.example.hippobookproject.dto.feed;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
@NoArgsConstructor
public class ReadCardDto {
    private Long readId;
    private Long userId;
    private Long bookId;
    private String userNickname;
    private String readTitle;
    private String readContent;
    private LocalDate readDate;
    private Long likeCnt;
    private Long feedFileId;
    private String feedFileName;
    private String feedUploadPath;
    private String feedUuId;
    private boolean isFollow;
}
