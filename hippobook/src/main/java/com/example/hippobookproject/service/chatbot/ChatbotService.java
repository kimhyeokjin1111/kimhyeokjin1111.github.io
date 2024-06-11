package com.example.hippobookproject.service.chatbot;

import com.example.hippobookproject.dto.chatbot.ChatbotDto;
import com.example.hippobookproject.dto.chatbot.ChatbotRespDto;
import com.example.hippobookproject.mapper.chatbot.ChatbotMapper;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ChatbotService {
    private final ChatbotMapper chatbotMapper;

    @Value("${api.ai}")
    String apiKey;

    public ChatbotRespDto respMap(Map<String, String> msg, Long userId){
        String url = "https://api.openai.com/v1/chat/completions";
        Map<String, String> setting = new HashMap<>();
        setting.put("role", "system");
        setting.put("content", "넌 이제부터 우리 사이트 상담사야 사이트 이용자가 질문하는 " +
                "내용에 성실히 답변해줘야 해 우리 사이트는 온라인 책장 사이트이고 책 리뷰를 " +
                "할 수 있는 커뮤니티에서 소통도 할 수 있어");

        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", msg.get("content"));

        List<Map> messages = new ArrayList<>();
        messages.add(setting);
        List<Map> chatHistory = findChatHistory(messages, userId);
        chatHistory.add(message);

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("model", "gpt-3.5-turbo");
        reqBody.put("messages", chatHistory);

        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .build();

        ChatbotRespDto resp = webClient.post()
                .body(BodyInserters.fromValue(reqBody))
                .retrieve()
                .bodyToMono(ChatbotRespDto.class)
                .block();

        log.info("resp = {}", resp);
        log.info("content = {}", resp.getChoices().get(0).getMessage().get("content"));

        String botChat = resp.getChoices().get(0).getMessage().get("content");

        registerChatHistory(msg.get("content"), botChat, userId);

        return resp;
    }

    public void registerChatHistory(String user, String bot, Long userId){
        ChatbotDto chatbotDto = new ChatbotDto();
        chatbotDto.setUserId(userId);
        chatbotDto.setUserChat(user);
        chatbotDto.setBotChat(bot);

        chatbotMapper.insertChatHistory(chatbotDto);
    }

    public List<Map> findChatHistory(List<Map> messages, Long userId){
        List<ChatbotDto> chatbotDtos = chatbotMapper.selectChatHistory(userId);

        for (int i = 0; i < chatbotDtos.size(); i++) {
            Map<String, String> userHistory = new HashMap<>();
            userHistory.put("role", "user");
            userHistory.put("content", chatbotDtos.get(i).getUserChat());

            Map<String, String> botHistory = new HashMap<>();
            botHistory.put("role", "assistant");
            botHistory.put("content", chatbotDtos.get(i).getBotChat());

            messages.add(userHistory);
            messages.add(botHistory);
        }
        return messages;
    }

    public void removeChatHistory(Long userId){
        chatbotMapper.deleteChatHistory(userId);
    }


}


