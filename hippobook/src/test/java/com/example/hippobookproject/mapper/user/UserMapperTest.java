package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.user.UserJoinDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    void insertUser(){
        UserJoinDto userDto = new UserJoinDto();
        userDto.setUserLoginId("test");
        userDto.setUserPassword("1234");
        userDto.setUserAge(22);
        userDto.setUserGender("M");
        userDto.setUserNickname("test");
        userDto.setUserPhonenumber("010111111111");

        userMapper.insertUser(userDto);
    }

    @Test
    void selectId() {
        Long userId = userMapper.selectId("test", "1234")
                .orElse(null);
        System.out.println("userId = " + userId);
    }
}























