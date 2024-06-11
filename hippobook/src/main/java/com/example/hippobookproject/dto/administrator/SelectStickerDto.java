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
public class SelectStickerDto {
    private String userName;
    private LocalDate startFollowDate;
    private LocalDate endFollowDate;
    private String fPermission;
}
