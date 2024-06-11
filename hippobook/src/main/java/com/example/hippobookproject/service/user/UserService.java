package com.example.hippobookproject.service.user;

import com.example.hippobookproject.dto.user.UserJoinDto;
import com.example.hippobookproject.dto.user.UserProfileDto;
import com.example.hippobookproject.mapper.user.UserIdDuplicateMapper;
import com.example.hippobookproject.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    @Value("${file.profile.dir}")
    private String profileDir;

    private final UserMapper userMapper;

    public void joinUser(UserJoinDto userJoinDto, MultipartFile multipartFile) throws IOException {

        String yymmdd = userJoinDto.getYymmdd();
        String genderNum = userJoinDto.getGenderNum();

        String yy = yymmdd.substring(0, 2);
        LocalDate today = LocalDate.now();
        String todayYY = today.format(DateTimeFormatter.ofPattern("yy"));

        int age = Integer.parseInt(todayYY) - Integer.parseInt(yy) + 1;


        String gender = null;

        if (genderNum.equals("1") || genderNum.equals("3")) {
            gender = "M";
        } else {
            gender = "F";
        }

        userJoinDto.setUserGender(gender);
        userJoinDto.setUserAge(age);


        userMapper.insertUser(userJoinDto);

        UserProfileDto userProfileDto = saveFile(multipartFile, userJoinDto.getUserId());

        userMapper.insertUserProfile(userProfileDto);
    }

    public Long findUserId(String userLoginId, String userPassword) {
        return userMapper.selectId(userLoginId, userPassword)
                .orElseThrow(() -> new IllegalStateException("아이디 혹은 비밀번호가 잘못되었습니다."));
    }

//    public void registerUserProfile(UserProfileDto userProfileDto) {
//        userMapper.insertUserProfile(userProfileDto);
//    }


    /**
     * 파일 저장처리 DB에 저장할 UserProfileDto를 반환함
     *
     * @param multipartFile 저장할 파일
     * @param userId        프로필의 주인 사용자 시퀀스
     * @return UserProfileDto를 반환함
     * @throws IOException
     */
    public UserProfileDto saveFile(MultipartFile multipartFile, Long userId) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        String uploadPath = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String uuid = UUID.randomUUID().toString();

//        C:/hippo_profile/2024/05/14
        File dirPath = new File(profileDir, uploadPath);

        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }

        String systemName = uuid + "_" + originalFilename;
        File fullPath = new File(dirPath, systemName);

        multipartFile.transferTo(fullPath);


        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setUserProfileName(originalFilename);
        userProfileDto.setUserProfileUploadPath(uploadPath);
        userProfileDto.setUserProfileUuid(uuid);
        userProfileDto.setUserId(userId);

        return userProfileDto;
    }

//    아이디 중복 검사

}
