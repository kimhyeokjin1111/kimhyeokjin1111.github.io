package com.example.hippobookproject.mapper.chatbot;

import com.example.hippobookproject.dto.chatbot.ChatbotDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatbotMapper {
    void insertChatHistory(ChatbotDto chatbotDto);

    List<ChatbotDto> selectChatHistory(Long userId);

    void deleteChatHistory(Long userId);
}
