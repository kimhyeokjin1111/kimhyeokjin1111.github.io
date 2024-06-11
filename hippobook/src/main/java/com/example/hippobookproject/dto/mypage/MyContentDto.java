package com.example.hippobookproject.dto.mypage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class MyContentDto {
        private Long feedId;
        private String feedTitle;
        private String feedType;
        private String feedDate;
        private Long userId;
        private Long bookId;
        private String bookName;
        private String bookWriter;
        private String cover;
        private Long totalLike;
        private Long fileId;
        private String fileName;
        private String fileUploadPath;
        private String fileUuid;
        private int reviewCnt;
        private int postCnt;
}
