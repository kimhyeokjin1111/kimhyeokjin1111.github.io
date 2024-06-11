package com.example.hippobookproject.dto.main;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DealListDto {
   private String dealTitle;
   private String userNickName;
   private String dealFileId;
   private String dealFileName;
   private String dealUploadPath;
   private String dealUuid;


//   DEAL_FILE_ID, DEAL_FILE_NAME, DEAL_UPLOAD_PATH, DEAL_UUID, DEAL_ID

//    DEAL_ID, DEAL_TITLE, DEAL_CONTENT, DEAL_DATE, USER_ID, DEAL_VIEW
}
