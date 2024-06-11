package com.example.hippobookproject.dto.feed;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FollowDto {
    private Long followId;
    private Long followTo;
    private Long followFrom;
}
