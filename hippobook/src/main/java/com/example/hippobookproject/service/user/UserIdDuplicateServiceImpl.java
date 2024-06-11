package com.example.hippobookproject.service.user;

import com.example.hippobookproject.mapper.user.UserIdDuplicateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserIdDuplicateServiceImpl implements UserIdDuplicateService {

    @Autowired
    private UserIdDuplicateMapper userIdDuplicateMapper;

    //아이디 중복체크 mapper 접근
    @Override
    public int idCheck(String userLoginId) {
        int cnt = userIdDuplicateMapper.idCheck(userLoginId);
        System.out.println("cnt: " + cnt);
        return cnt;
    }
}
