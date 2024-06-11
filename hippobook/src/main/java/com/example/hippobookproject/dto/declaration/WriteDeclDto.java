package com.example.hippobookproject.dto.declaration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class WriteDeclDto {
    private String declContent;
    private String declCate;
    private Long targetId;
    private Long userId;
}
