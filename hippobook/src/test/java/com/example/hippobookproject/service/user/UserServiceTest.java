package com.example.hippobookproject.service.user;

import com.example.hippobookproject.mapper.user.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    UserMapper userMapper;

    @Test
    void dateTest(){
        LocalDate today = LocalDate.now();
        String todayYY = today.format(DateTimeFormatter.ofPattern("yy"));

        System.out.println("todayYY = " + todayYY);
    }
    
    @Test
    void findIdTest(){
        Long foundIdTest = null;
        try {
            foundIdTest = userService.findUserId("test", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("foundIdTest = " + foundIdTest);
    }


    @Test
    void dateTest2(){
        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);

        String format = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("format = " + format);
    }
}