package com.example.hippobookproject.mapper.chatbot;

import com.example.hippobookproject.dto.chatbot.ChatbotDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ChatbotMapperTest {
    @Autowired
    ChatbotMapper chatbotMapper;

    ChatbotDto chatbotDto;
    @BeforeEach
    void setUp() {
        chatbotDto = new ChatbotDto();
        chatbotDto.setUserChat("안녕");
        chatbotDto.setBotChat("안녕하세요!~~");
        chatbotDto.setUserId(1L);

        chatbotMapper.insertChatHistory(chatbotDto);
    }

    @Test
    void selectChatHistory() {
        List<ChatbotDto> chatbotDtos = chatbotMapper.selectChatHistory(chatbotDto.getUserId());
        assertThat(chatbotDtos)
                .extracting("userChat")
                .contains("안녕");
    }

    @Test
    void deleteChatHistory() {
        chatbotMapper.deleteChatHistory(chatbotDto.getUserId());
        List<ChatbotDto> chatbotDtos = chatbotMapper.selectChatHistory(chatbotDto.getUserId());
        assertThat(chatbotDtos)
                .isEmpty();
    }
}