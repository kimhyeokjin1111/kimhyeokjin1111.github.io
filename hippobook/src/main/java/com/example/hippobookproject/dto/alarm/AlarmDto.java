package com.example.hippobookproject.dto.alarm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AlarmDto {
    private Long alarmId;
    private String alarmContent;
    private String alarmCheck;
    private Long alarmTo;
    private Long alarmFrom;
    private String userNickName;

//   ALARM_ID, ALARM_CONTENT, ALARM_DATE, ALARM_CHECK, ALARM_TO, ALARM_FROM
}
