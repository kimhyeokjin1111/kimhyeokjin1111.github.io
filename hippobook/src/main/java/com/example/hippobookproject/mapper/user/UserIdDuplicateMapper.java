package com.example.hippobookproject.mapper.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserIdDuplicateMapper {

    int idCheck(String userLoginId);
}
