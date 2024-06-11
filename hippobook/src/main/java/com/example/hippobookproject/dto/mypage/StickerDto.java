package com.example.hippobookproject.dto.mypage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class StickerDto {
    Long userId;
    Long stikerId;
    String stickerPermissionCheck;
    String stickerRead;
}
