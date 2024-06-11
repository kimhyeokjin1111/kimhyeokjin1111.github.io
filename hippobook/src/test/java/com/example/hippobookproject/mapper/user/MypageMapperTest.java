package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.mypage.*;
import com.example.hippobookproject.dto.user.UserJoinDto;
import com.example.hippobookproject.dto.user.UserProfileDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MypageMapperTest {

    @Autowired
    MypageMapper mypageMapper;

    IntProfileDto intProfileDto;
    IntBoardDto intBoardDto;
    BookContainerDto bookContainerDto;
    MyContentDto myContentDto;
    StickerDto stickerDto;
    UserJoinDto userJoinDto;
    UserProfileDto userProfileDto;

    @Test
    void selectProfile() {

        mypageMapper.selectProfile(1L);

    }


    @Test
    void setUp() {
        intBoardDto = new IntBoardDto();
        intBoardDto.setUserId(1L);
        intBoardDto.setIntBoardContent("안녕하세요!!!!");
        intBoardDto.setIntBoardId(1L);
        mypageMapper.insertIntBoardText(intBoardDto);
        System.out.println("intBoardDto = " + intBoardDto);

    }


    @Test
    void selectIntBoardText() {
        mypageMapper.selectIntBoardText(1L);
    }

    @Test
    void updateIntBoardText() {
        intBoardDto = new IntBoardDto();
        intBoardDto.setUserId(1L);
        intBoardDto.setIntBoardContent("하이");
        mypageMapper.updateIntBoardText(intBoardDto);

    }

    @Test
    void selectRecentBook() {
        List<BookContainerDto> bookRecentList = mypageMapper.selectRecentBook(1L);
        System.out.println("bookRecentList = " + bookRecentList);

    }

    @Test
    void selectMyContent() {
        List<MyContentDto> myContentList = mypageMapper.selectMyContent(1L);
        System.out.println("myContentList = " + myContentList);

    }

    @Test
    void selectReviewCount() {
        Long reviewCount = mypageMapper.selectReviewCount(1L);
    }

    @Test
    void selectPostCount() {
        Long postCount = mypageMapper.selectPostCount(1L);
    }

    @Test
    void selectProfilePhoto() {
        mypageMapper.selectProfilePhoto(21L);
    }

    @Test
    void insertSticker() {
        stickerDto = new StickerDto();
        stickerDto.setUserId(1L);
        stickerDto.setStikerId(1L);
        stickerDto.setStickerPermissionCheck("N");
        stickerDto.setStickerRead("N");
        mypageMapper.insertSticker(stickerDto);
        System.out.println("stickerDto = " + stickerDto);

    }

    @Test
    void selectSticker() {
        Long stickerCnt = mypageMapper.selectSticker(1L);
        System.out.println("stickerCnt = " + stickerCnt);
    }

    @Test
    void deleteUser() {
        mypageMapper.deleteUser(1L);
    }

    @Test
    void
    updateUserNickName() {
        intProfileDto = new IntProfileDto();
        intProfileDto.setUserId(1L);
        intProfileDto.setUserNickName("bbb");
        mypageMapper.updateUserNickName(intProfileDto);

    }



    @Test
    void updateProfilePhoto() {
        intProfileDto= new IntProfileDto();
        intProfileDto.setUserProfileName("test");
        intProfileDto.setUserProfileUploadPath("2010/04/02");
        intProfileDto.setUserProfileUuid("TEST");
        intProfileDto.setUserId(intProfileDto.getUserId());

        mypageMapper.updateUserProfilePhoto(intProfileDto);

        assertThat(intProfileDto)
                .isNotNull()
                .extracting("userId")
                .isEqualTo(intProfileDto.getUserId());

    }

    @Test
    void selectCheckSticker(){
        String read = mypageMapper.selectCheckSticker(1L);
        System.out.println("read = " + read);
    }

    @Test
    void selectOldProfilePhoto(){
        List<IntProfileDto> intProfileDto = mypageMapper.selectOldProfilePhoto();
        System.out.println("intProfileDto = " + intProfileDto);
    }
}