package com.example.hippobookproject.dto.mypage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter @ToString
@NoArgsConstructor
public class BookContainerDto {
    private String bookName;
    private String bookWriter;
    private Long bookHasId;
    private Long bestBookId;
    private String bookHasPercent;
    private Long bookCaseId;
    private Long bookId;
    private Long userId;
    private LocalDate bookCaseCreate;
    private String bookHasRecentDate;
    private String cover;
}
