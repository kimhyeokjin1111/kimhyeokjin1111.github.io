package com.example.hippobookproject.dto.main;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReadListDto {
    private String ReadTitle;
    private String ReadContent;
    private String userNickName;
    private Long readFileId;
    private String readFileName;
    private String readUploadPath;
    private String readUuId;

}
