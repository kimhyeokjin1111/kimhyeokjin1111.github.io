package com.example.hippobookproject.dto.alarm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeDto {

    private String noticeTitle;
    private String noticeContent;
    private String noticeDate;


//    NOTICE_ID, NOTICE_CONTENT, NOTICE_DATE, NOTICE_TO, NOTICE_FROM
}
