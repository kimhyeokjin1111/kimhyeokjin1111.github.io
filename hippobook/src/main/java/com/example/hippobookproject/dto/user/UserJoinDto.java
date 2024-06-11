package com.example.hippobookproject.dto.user;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
public class UserJoinDto {
    private Long userId;
    private String userNickname;
    private String userLoginId;
    private String userPassword;
    private String userPhonenumber;
    private String userGender;
    private int userAge;

    private String yymmdd;
    private String genderNum;
}
