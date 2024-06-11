package com.example.hippobookproject.service.message;

import com.example.hippobookproject.dto.alarm.AlarmDto;
import com.example.hippobookproject.dto.message.MessageDto;
import com.example.hippobookproject.dto.message.MessageNicknameDto;
import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.dto.page.MessageCriteria;
import com.example.hippobookproject.mapper.alarm.AlarmMapper;
import com.example.hippobookproject.mapper.message.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageService {
    private final MessageMapper messageMapper;
    private final AlarmMapper alarmMapper;

    public MessageNicknameDto findUserNickname(String userNickname){
        return messageMapper.selectUserNickname(userNickname)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 닉네임"));
    }

    public boolean isNicknameDuplicated(String userNickname){
        return messageMapper.selectUserNickname(userNickname).isPresent();
    }

    public void registerMessageWrite(MessageDto messageDto,AlarmDto alarmDto){
        messageMapper.insertMessage(messageDto);
        alarmMapper.insertAlarm(alarmDto);
    }

    public List<MessageDto> findGetMessage(@Param("userId") Long userId,
                                           @Param("messageCriteria") MessageCriteria messageCriteria) {

        return messageMapper.selectGetMessage(userId,messageCriteria);
    }

    public List<MessageDto> findPostMessage(@Param("userId") Long userId,
                                            @Param("messageCriteria") MessageCriteria messageCriteria) {

        return messageMapper.selectPostMessage(userId,messageCriteria);
    }

    public void removeMessage(List<Long> idList) {

        messageMapper.deleteMessage(idList);

    }

    public MessageDto findMessageView(Long messageId){
        return messageMapper.selectMessageView(messageId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 쪽지"));
    };

    public int findTotalGetMessage(Long userId){
        return messageMapper.selectTotalGetMessage(userId);
    }

    public int findTotalPostMessage(Long userId){
        return messageMapper.selectTotalPostMessage(userId);
    }

    public String findGetUserNickName(Long messageFrom){
        return messageMapper.selectGetUserNickName(messageFrom);
    };

}
