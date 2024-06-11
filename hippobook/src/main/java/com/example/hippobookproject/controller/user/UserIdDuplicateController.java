package com.example.hippobookproject.controller.user;

import com.example.hippobookproject.service.user.UserIdDuplicateService;
import com.example.hippobookproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/user")
public class UserIdDuplicateController {

    @Autowired
    private UserIdDuplicateService userIdDuplicateService;

    @PostMapping("/register")
    @ResponseBody
    public int idCheck(@RequestParam("userLoginId") String userLoginId) {

        return userIdDuplicateService.idCheck(userLoginId);
    }
}
