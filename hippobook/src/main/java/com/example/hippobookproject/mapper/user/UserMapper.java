package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.user.UserJoinDto;
import com.example.hippobookproject.dto.user.UserProfileDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void insertUser(UserJoinDto userJoinDto);

    Optional<Long> selectId(@Param("userLoginId") String userLoginId,
                            @Param("userPassword") String userPassword);

    void insertUserProfile(UserProfileDto userProfileDto);

}
