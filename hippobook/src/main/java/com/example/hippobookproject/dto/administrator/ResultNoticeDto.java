package com.example.hippobookproject.dto.administrator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResultNoticeDto {
    Long noticeId;
    LocalDate noticeDate;
    String noticeType;
    String noticeUser;
}
