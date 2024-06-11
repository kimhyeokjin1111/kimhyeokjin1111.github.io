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
public class ResultStickerDto {
//    STIKER_ID, STIKER_DATE,USER_ID, USER_NAME, USER_NICKNAME,
//    USER_GENDER, USER_AGE, FCNT
    private Long stickerId;
    private LocalDate skickerDate;
    private Long userId;
    private String userName;
    private String userNickname;
    private String userGender;
    private int userAge;
    private int followCnt;
}
