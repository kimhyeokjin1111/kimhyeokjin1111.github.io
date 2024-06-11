package com.example.hippobookproject.dto.chatbot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
@NoArgsConstructor
public class ChatbotRespDto {
    private String id;
    private String obj;
    private String created;
    private String model;
    private List<ChatbotChoiceDto> choices;
}
