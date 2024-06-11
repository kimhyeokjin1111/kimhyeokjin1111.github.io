package com.example.hippobookproject.service.mypage;

import com.example.hippobookproject.dto.mypage.*;
import com.example.hippobookproject.dto.user.UserProfileDto;
import com.example.hippobookproject.mapper.user.MypageBookContainerMapper;
import com.example.hippobookproject.mapper.user.MypageMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MypageService {
    private final MypageMapper mypageMapper;
    private final MypageBookContainerMapper mypageBookContainerMapper;

    @Value("${file.profile.dir}")
    private String profileDir;

    public IntProfileDto findProfile(Long userId) {
        return mypageMapper.selectProfile(userId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원 번호"));

    }

    public void registerIntBoardText(IntBoardDto intBoardDto) {


        Optional<IntBoardDto> intBoard = mypageMapper.selectIntBoardText(intBoardDto.getUserId());

        if (intBoard.isPresent()) {
            IntBoardDto oldBoard = intBoard.get();
            if (intBoardDto.getIntBoardContent() == null){
                intBoardDto.setIntBoardId(oldBoard.getIntBoardId());
                mypageMapper.updateIntBoardText(intBoardDto);
            }else{
                mypageMapper.updateIntBoardText(intBoardDto);
            }

        } else {
            mypageMapper.insertIntBoardText(intBoardDto);
        }


    }

    public IntBoardDto findIntBoardText(Long userId) {

        return mypageMapper.selectIntBoardText(userId)
                .orElse(new IntBoardDto());
    }

    public List<BookContainerDto> findBookContainer(Long userId) {

        return mypageBookContainerMapper.selectBookContainer(userId);
    }

    public void removeBookContainer(Long bookHasId) {
//       List<BookContainerDto> bookContainerDtoList = mypageBookContainerMapper.selectBookContainer(userId);
        mypageBookContainerMapper.deleteBookHas(bookHasId);

    }

    public BookContainerDto findBestBook(Long userId) {
        return mypageBookContainerMapper.selectBestBook(userId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원번호"));
    }

    public void modifyBestBook(BookContainerDto bookContainerDto) {
        mypageBookContainerMapper.updateBestBook(bookContainerDto);

    }

    public void modifyBookStatus(BookContainerDto bookContainerDto) {
        mypageBookContainerMapper.updateBookStatus(bookContainerDto);

    }

    public List<BookContainerDto> findRecentBook(Long userId) {
        return mypageMapper.selectRecentBook(userId);
    }

    public List<MyContentDto> findMyContent(Long userId) {
        return mypageMapper.selectMyContent(userId);
    }

    public Long findReviewCount(Long userId) {
        return mypageMapper.selectReviewCount(userId);
    }

    public Long findPostCount(Long userId) {
        return mypageMapper.selectPostCount(userId);
    }

    public IntProfileDto findProfilePhoto(Long userId) {
        return mypageMapper.selectProfilePhoto(userId)
                .orElse(new IntProfileDto());
    }

    public void registerSticker(@Param("stickerDto") StickerDto stickerDto,
                                @Param("userId") Long userId) {

        Long stickerCnt = mypageMapper.selectSticker(userId);

        if (stickerCnt == 0) {
            mypageMapper.insertSticker(stickerDto);
        }

    }

    public String findCheckSticker(Long userId){

        return mypageMapper.selectCheckSticker(userId);
    }

    public void removeUser(Long userId) {
        mypageMapper.deleteUser(userId);
    }

    public void modifyNickName(IntProfileDto intProfileDto) {

        mypageMapper.updateUserNickName(intProfileDto);

    }

    /**
     *
     * @param userId : 세션에서 받는 유저 아이디
     * @param multipartFile : 프로필 사진 변경을 누르고 파일을 선택하면 생성되는 파일
     */
    public void modifyProfilePhoto(Long userId, MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        originalFilename = originalFilename.replaceAll(" ", "_");
        String uuid = UUID.randomUUID().toString();
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String uploadPath = now.format(dateTimeFormatter);

        File dirPath = new File(profileDir, uploadPath);

        if(!dirPath.exists()){
            dirPath.mkdirs();
        }

        String fileSysName = uuid + "_" + originalFilename;

        File fullPath = new File(dirPath, fileSysName);


        try {
            multipartFile.transferTo(fullPath);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        IntProfileDto intProfileDto = new IntProfileDto();
        intProfileDto.setUserId(userId);
        intProfileDto.setUserProfileName(originalFilename);
        intProfileDto.setUserProfileUuid(uuid);
        intProfileDto.setUserProfileUploadPath(uploadPath);

        mypageMapper.updateUserProfilePhoto(intProfileDto);
    }

    public List<IntProfileDto> findProfilePhotoList(Long userId){
        return  mypageMapper.selectProfilePhotoList(userId);
    }

    public List<IntProfileDto> findOldProfilePhoto(){
        return  mypageMapper.selectOldProfilePhoto();
    }




}
