package com.example.hippobookproject.service.attendance;

import com.example.hippobookproject.mapper.attendance.AttendanceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceMapper attendanceMapper;
}
