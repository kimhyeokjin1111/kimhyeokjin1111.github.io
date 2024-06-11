package com.example.hippobookproject.dto.chatbot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ChatbotWriteDto {
    private Long userId;
    private LocalDate today;
}
