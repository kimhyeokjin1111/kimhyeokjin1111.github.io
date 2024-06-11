package com.example.hippobookproject.dto.mypage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@NoArgsConstructor
public class IntProfileDto {
    private Long userId;
    private String userNickName;
    private String userEmail;
    private Long followingCnt;
    private Long followerCnt;
    private Long bestBookId;
    private String cover;
    private Long fileId;
    private String fileUploadPath;
    private String fileUuid;
    private String fileName;
    private Long userProfileId;
    private String userProfileUploadPath;
    private String userProfileUuid;
    private String userProfileName;


}
