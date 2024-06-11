package com.example.hippobookproject.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class UserProfileDto {
    private Long userProfileId;
    private String userProfileUploadPath;
    private String userProfileUuid;
    private String userProfileName;
    private Long userId;
}
