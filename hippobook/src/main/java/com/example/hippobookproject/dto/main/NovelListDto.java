package com.example.hippobookproject.dto.main;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class NovelListDto {
   private String novelTitle;
   private String novelContent;
   private Long userId;
   private String userNickName;
   private Long userProfileId;
   private String userProfileName;
   private String userProfileUploadPath;
   private String userProfileUuId;
//   USER_PROFILE_ID, USER_PROFILE_NAME, USER_PROFILE_UPLOAD_PATH, USER_PROFILE_UUID

//    PP.PHOTO_FILE_ID, PP.FILE_NAME, PP.FILE_UPLOAD_PATH, PP.FILE_UUID
}
