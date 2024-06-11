package com.example.hippobookproject.dto.chatbot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter @Setter @ToString
@NoArgsConstructor
public class ChatbotChoiceDto {
    int index;
    Map<String, String> message;
}
