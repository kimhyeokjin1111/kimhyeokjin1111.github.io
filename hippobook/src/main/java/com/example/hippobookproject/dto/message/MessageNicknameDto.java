package com.example.hippobookproject.dto.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MessageNicknameDto {
    private Long userId;
    private String userNickname;
    private Long messageFrom;
    private Long messageTo;

}
