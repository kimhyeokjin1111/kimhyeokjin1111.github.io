package com.example.hippobookproject.service.alarm;

import com.example.hippobookproject.dto.alarm.AlarmDto;
import com.example.hippobookproject.dto.feed.FollowDto;
import com.example.hippobookproject.dto.message.MessageDto;
import com.example.hippobookproject.mapper.alarm.AlarmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AlarmService {
    private final AlarmMapper alarmMapper;


    public List<AlarmDto> findById(Long userId) {
        return alarmMapper.findByID(userId);
    }

//    public void insertAlarm(AlarmDto alarmDto) {
//        alarmMapper.insertAlarm(alarmDto);
//    }

    public void updateAlarmCheckByUserId(Long userId) {
        alarmMapper.updateAlarmCheckByUserId(userId);
    }


    public boolean hasUncheckedAlarms(Long userId) {
        return alarmMapper.hasUncheckedAlarms(userId);
    }

    public boolean messageCheckedAlarms(Long userId) {
        return alarmMapper.messageCheckedAlarms(userId);
    }

//    메시지 알림 조회하기
    public List<MessageDto> selectMessageAlarm(){
        return alarmMapper.selectMessageAlarm();
    }

//    팔로우 알림 조회하기
    public List<FollowDto> selectFollowAlarm(){
        return alarmMapper.selectFollowAlarm();
    }



}
