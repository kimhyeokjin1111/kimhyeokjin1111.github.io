package com.example.hippobookproject.controller.message;

import com.example.hippobookproject.dto.alarm.AlarmDto;
import com.example.hippobookproject.dto.message.MessageDto;
import com.example.hippobookproject.dto.message.MessageNicknameDto;
import com.example.hippobookproject.dto.page.MessageCriteria;
import com.example.hippobookproject.dto.page.MessagePage;
import com.example.hippobookproject.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/letter/write")
    public String letterWrite(@SessionAttribute("userId") Long userId
                              ,Model model){


        return "message/letterWrite";
    }

    @PostMapping("/letter/write")
    public String letterWrite(@SessionAttribute("userId") Long userId,
                              MessageDto messageDto, AlarmDto alarmDto,
                              String userNickname,
                              Model model){

        MessageNicknameDto nicknameDto = messageService.findUserNickname(userNickname);
        model.addAttribute("nicknameDto",nicknameDto);
        log.info("nicknameDto = {}",nicknameDto);


        messageDto.setMessageFrom(userId);
        messageDto.setMessageTo(nicknameDto.getUserId());
        alarmDto.setAlarmFrom(userId);
        alarmDto.setAlarmTo(nicknameDto.getUserId());
        alarmDto.setAlarmContent("쪽지가 도착했습니다");

        messageService.registerMessageWrite(messageDto,alarmDto);
        log.info("messageDto={}",messageDto);
        log.info("alarmDto={}",alarmDto);

        return "redirect:/message/letter/send";
    }

    @GetMapping("/letter/view")
    public String letterView(Model model, Long messageId){
        MessageDto messageViewDto = messageService.findMessageView(messageId);
        model.addAttribute("messageViewDto",messageViewDto);
        log.info("messageViewDto={}", messageViewDto);


        return "message/letterView";
    }

    @GetMapping("/letter/get")
    public String getLetter(MessageCriteria messageCriteria, Model model, @SessionAttribute("userId") Long userId){
        List<MessageDto> getMessageList = messageService.findGetMessage(userId,messageCriteria);
        int total = messageService.findTotalGetMessage(userId);
        MessagePage page = new MessagePage(messageCriteria, total);

        model.addAttribute("getMessageList",getMessageList);
        model.addAttribute("page", page);

        log.info("getMessageList={}", getMessageList);



        return "message/get_letter";
    }

    @PostMapping("/letter/get")
    public String getLetter(@SessionAttribute("messageId") Long messageId,
                            Model model){
        MessageDto msgDto = new MessageDto();
        msgDto.setMessageId(messageId);

        model.addAttribute("msgDto",msgDto);
        log.info("msgDto={}",msgDto);

        return "/letter/view";
    }

    @GetMapping("/letter/send")
    public String sendLetter(MessageCriteria messageCriteria, Model model, @SessionAttribute("userId") Long userId){

        List<MessageDto> postMessageList = messageService.findPostMessage(userId,messageCriteria);
        int total = messageService.findTotalPostMessage(userId);
        MessagePage page = new MessagePage(messageCriteria, total);

        model.addAttribute("postMessageList",postMessageList);
        model.addAttribute("page", page);


        log.info("postMessageList={}", postMessageList);
        return "message/send_letter";
    }
}
