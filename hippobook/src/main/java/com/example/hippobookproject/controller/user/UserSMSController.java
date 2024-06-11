package com.example.hippobookproject.controller.user;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UserSMSController {

    private final DefaultMessageService messageService;

    public UserSMSController(){
        this.messageService = NurigoApp.INSTANCE.initialize("NCSY9XIYBUMND1DU", "EALLGJXCESAO60SMBUXZMTNITX0QKCCB", "https://api.coolsms.co.kr");
    }

    @RequestMapping(value = "registerPhoneCode" , method = RequestMethod.POST)
    public SingleMessageSentResponse sendOne() {
        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01098999423");
        message.setTo("01098999423");
        message.setText("히포북 인증 메세지\n인증번호 : " + makeRandomNumber());

        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);

        return response;
    }

    private String makeRandomNumber(){
        Random r = new Random();
        String randomNumber = "";

        for (int i = 0; i < 6; i++) {
            randomNumber += r.nextInt(10);
        }

        return randomNumber;
    }
}