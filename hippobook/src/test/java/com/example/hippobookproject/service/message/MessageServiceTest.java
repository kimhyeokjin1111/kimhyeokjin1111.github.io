package com.example.hippobookproject.service.message;

import com.example.hippobookproject.dto.message.MessageDto;
import com.example.hippobookproject.dto.message.MessageNicknameDto;
import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.dto.mypage.IntBoardDto;
import com.example.hippobookproject.dto.mypage.IntProfileDto;
import com.example.hippobookproject.dto.user.UserJoinDto;
import com.example.hippobookproject.mapper.message.MessageMapper;
import org.apache.ibatis.annotations.Many;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @Mock
    MessageMapper messageMapper;

    @InjectMocks
    MessageService messageService;

    @Test
    void findUserNickname() {
        // given
        MessageNicknameDto dto = new MessageNicknameDto();
        dto.setUserNickname("test");
        doReturn(Optional.of(dto)).when(messageMapper).selectUserNickname(any());
        // when
        MessageNicknameDto messageNicknameDto = messageService.findUserNickname(any());
        // then
        assertThat(messageNicknameDto).extracting("userNickname").isEqualTo("test");
    }

//    @Test
//    void registerMessageWrite() {
//        //given
//        Mockito.doNothing().when(messageMapper).insertMessage(any());
//        // when
//        messageService.registerMessageWrite(new MessageDto());
//        // then
//        Mockito.verify(messageMapper, Mockito.times(1)).insertMessage(any());
//    }

    @Test
    void findGetMessage(){
        doReturn(List.of(new MessageDto())).when(messageMapper).selectGetMessage(any(),any());
        // when
        List<MessageDto> getMessageList = messageService.findGetMessage(any(),any());
        // then
        assertThat(getMessageList).hasSize(1);
    }

    @Test
    void findPostMessage(){
        doReturn(List.of(new MessageDto())).when(messageMapper).selectPostMessage(any(),any());
        // when
        List<MessageDto> postMessageList = messageService.findPostMessage(any(),any());
        // then
        assertThat(postMessageList).hasSize(1);
    }

//    @Test
//    void removeMessage() {
//        //given
//        doNothing().when(messageMapper).deleteMessage(any());
//        //when
//        messageService.removeMessage(2L);
//        //then
//        verify(messageMapper, times(1)).deleteMessage(any());
//
//    }

    @Test
    void findMessageView(){
        MessageDto dto = new MessageDto();
        dto.setMessageId(2L);
        doReturn(Optional.of(dto)).when(messageMapper).selectMessageView(any());
        // when
        MessageDto messageView = messageService.findMessageView(any());
        // then
        assertThat(messageView).extracting("messageId").isEqualTo(2L);
    }

}