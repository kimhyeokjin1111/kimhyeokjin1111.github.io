package com.example.hippobookproject.api.mypage;

import com.example.hippobookproject.dto.mypage.IntProfileDto;
import com.example.hippobookproject.service.mypage.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProfilePhotoApi {
    private final MypageService mypageService;

    @PatchMapping("/v1/users/profiles")
    public void modifyProfilePhoto(@RequestParam("profile") MultipartFile multipartFile,
                                   @SessionAttribute("userId") Long userId){

        mypageService.modifyProfilePhoto(userId, multipartFile);

        log.info("file : {}", multipartFile.getOriginalFilename());
    }


}
