package com.example.hippobookproject.mapper.message;

import com.example.hippobookproject.dto.message.MessageDto;
import com.example.hippobookproject.dto.message.MessageNicknameDto;
import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.dto.page.MessageCriteria;
import com.example.hippobookproject.dto.user.UserJoinDto;
import com.jayway.jsonpath.Criteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
class MessageMapperTest {
    @Autowired
    MessageMapper messageMapper;

    MessageDto messageDto;
    UserJoinDto userJoinDto;
    MessageNicknameDto messageNicknameDto;

    @BeforeEach
    void setUp() {
        messageDto = new MessageDto();
        messageDto.setMessageId(1L);
        messageDto.setMessageTitle("test");
        messageDto.setMessageContent("test-content");
        messageDto.setMessageCheck("N");
        messageDto.setMessageTo(2L);
        messageDto.setMessageFrom(1L);
        messageMapper.insertMessage(messageDto);
        System.out.println("messageDto = " + messageDto);

    }


    @Test
    void selectUserNickname() {

        messageNicknameDto = new MessageNicknameDto();
        messageNicknameDto.setUserNickname("test");

        messageMapper.selectUserNickname("test");
    }


    @Test
    void selectGetMessage() {
        MessageCriteria messageCriteria = new MessageCriteria();
        messageCriteria.setPage(1);
        messageCriteria.setAmount(10);

        List<MessageDto> getMessage = messageMapper.selectGetMessage(1L, messageCriteria);
        System.out.println("getMessage = " + getMessage);
        assertThat(getMessage).hasSize(10);
    }

    @Test
    void selectPostMessage() {
        MessageCriteria messageCriteria = new MessageCriteria();
        messageCriteria.setPage(1);
        messageCriteria.setAmount(10);

        List<MessageDto> postMessage = messageMapper.selectPostMessage(1L, messageCriteria);
        System.out.println("postMessage = " + postMessage);
        assertThat(postMessage).hasSize(10);
    }

    @Test
    void deleteMessage() {
//        //given
//        List<MessageDto> messageDtoList = messageMapper.selectGetMessage(2L);
//
//        //when
//        int oldSize = messageDtoList.size();
//        MessageDto messageDto = messageDtoList.get(0);
//
//        Long messageId = messageDto.getMessageId();
////        messageMapper.deleteMessage(messageId);
//
//        List<MessageDto> list = messageMapper.selectGetMessage(2L);
//
//        //then
//        assertThat(list.size()).isEqualTo(oldSize - 1);
    }

    @Test
    void selectMessageView() {
        messageDto = new MessageDto();
        messageDto.setMessageId(1L);
        messageMapper.selectMessageView(messageDto.getMessageId());
    }

    @Test
    void selectTotalGetMessage() {
        messageMapper.selectTotalGetMessage(1L);
    }


    @Test
    void updateReadingCheck() {

        messageMapper.updateReadingCheck(45L);


    }

    @Test
    void selectGetUserNickName(){
        String nickName = messageMapper.selectGetUserNickName(21L);
        System.out.println("nickName = " + nickName);
    }

}