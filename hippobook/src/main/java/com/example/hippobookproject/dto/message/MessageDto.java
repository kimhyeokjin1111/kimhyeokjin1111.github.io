package com.example.hippobookproject.dto.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
@NoArgsConstructor
public class MessageDto {
       private Long messageId;
       private String messageTitle;
       private String messageContent;
       private String messageCheck;
       private LocalDate messageDate;
       private Long messageTo;
       private Long messageFrom;
       private String userNickname;
}
