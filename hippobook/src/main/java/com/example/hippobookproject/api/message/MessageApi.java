package com.example.hippobookproject.api.message;

import com.example.hippobookproject.dto.message.MessageNicknameDto;
import com.example.hippobookproject.service.message.MessageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageApi {

    private final MessageService messageService;

    @DeleteMapping("/v1/messages")
    public void getLetter(@RequestParam("id") List<Long> idList,
                          HttpSession session){
        log.info("messageId = {}",idList);

        messageService.removeMessage(idList);
    }

    @DeleteMapping("/v2/messages")
    public void sendLetter(@RequestParam("id") List<Long> idList,
                          HttpSession session){
        log.info("messageId = {}",idList);

        messageService.removeMessage(idList);
    }

    @GetMapping("/v1/nickname/{userNickname}")
    public boolean letterWrite(@PathVariable("userNickname") String userNickname){
        log.info("userNickname = " + userNickname);

        return messageService.isNicknameDuplicated(userNickname);
    }

}
