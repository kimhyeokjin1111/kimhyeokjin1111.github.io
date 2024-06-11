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
public class ChatbotDto {
    private Long userId;
    private String userChat;
    private String botChat;
    private LocalDate today;
}
