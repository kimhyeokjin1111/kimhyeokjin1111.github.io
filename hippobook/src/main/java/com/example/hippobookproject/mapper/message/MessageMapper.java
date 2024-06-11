package com.example.hippobookproject.mapper.message;

import com.example.hippobookproject.dto.message.MessageDto;
import com.example.hippobookproject.dto.message.MessageNicknameDto;
import com.example.hippobookproject.dto.page.MessageCriteria;
import com.example.hippobookproject.dto.user.UserJoinDto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MessageMapper {
    void insertMessage(MessageDto messageDto);

    Optional<MessageNicknameDto> selectUserNickname(String userNickname);

    List<MessageDto> selectGetMessage(@Param("userId") Long userId,
                                      @Param("messageCriteria") MessageCriteria messageCriteria);

    List<MessageDto> selectPostMessage(@Param("userId") Long userId,
                                       @Param("messageCriteria") MessageCriteria messageCriteria);

    void deleteMessage(@Param("idList") List<Long> idList);

    Optional<MessageDto> selectMessageView(Long messageId);

    int selectTotalGetMessage(Long userId);

    int selectTotalPostMessage(Long userId);

    void updateReadingCheck(Long messageId);

    String selectGetUserNickName(Long messageFrom);


}
