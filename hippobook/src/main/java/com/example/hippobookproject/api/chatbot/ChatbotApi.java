package com.example.hippobookproject.api.chatbot;

import com.example.hippobookproject.dto.chatbot.ChatbotRespDto;
import com.example.hippobookproject.service.chatbot.ChatbotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatbotApi {
    private final ChatbotService chatbotService;

    @PostMapping("/v1/ai/reply")
    public ChatbotRespDto chatbotTest(@RequestBody Map<String, String> msg,
                                      @SessionAttribute("userId") Long userId ){
//        log.info("msg = " + msg);
        log.info("msg = " + msg + ", userId = " + userId);
        return chatbotService.respMap(msg, userId);
    }

    @DeleteMapping("/v1/ai")
    public void exitChatbot(@SessionAttribute("userId") Long userId){
        chatbotService.removeChatHistory(userId);
    }
}
