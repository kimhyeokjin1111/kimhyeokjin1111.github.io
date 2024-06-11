package com.example.hippobookproject.dto.mypage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class IntBoardDto {
    private Long intBoardId;
    private String intBoardContent;
    private Long userId;

}
