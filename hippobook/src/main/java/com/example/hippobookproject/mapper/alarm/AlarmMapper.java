package com.example.hippobookproject.mapper.alarm;

import com.example.hippobookproject.dto.alarm.AlarmDto;
import com.example.hippobookproject.dto.feed.FollowDto;
import com.example.hippobookproject.dto.message.MessageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
    public interface AlarmMapper {
    List<AlarmDto> findByID(Long userId);
    void insertAlarm(AlarmDto alarmDto);
    void updateAlarmCheckByUserId(Long userId);

    Boolean hasUncheckedAlarms(Long userId);

//    메시지 알림
    List<MessageDto> selectMessageAlarm();

    List<FollowDto> selectFollowAlarm();

    boolean messageCheckedAlarms(Long userId);

    List<AlarmDto> findByMessage(Long userId);
}
