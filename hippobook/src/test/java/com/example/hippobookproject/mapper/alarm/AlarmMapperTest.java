package com.example.hippobookproject.mapper.alarm;

import com.example.hippobookproject.dto.alarm.AlarmDto;
import com.example.hippobookproject.service.alarm.AlarmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class AlarmMapperTest {
    @Autowired
    AlarmMapper alarmMapper;

    AlarmDto alarmDto;

    @Test
    void updateAlarmCheckByUserId() {

    }

    @Test
    void hasUncheckedAlarms() {

        Boolean check = alarmMapper.hasUncheckedAlarms(21L);
        System.out.println(check);


    }
}