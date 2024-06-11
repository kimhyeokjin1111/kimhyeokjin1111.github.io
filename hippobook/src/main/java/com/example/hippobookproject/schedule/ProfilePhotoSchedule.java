package com.example.hippobookproject.schedule;

import com.example.hippobookproject.dto.mypage.IntProfileDto;
import com.example.hippobookproject.service.file.FileService;
import com.example.hippobookproject.service.mypage.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProfilePhotoSchedule {

    private final MypageService mypageService;

    @Value("C:/hippo_profile/")
    private String fileDir;

    @Scheduled(cron = "* * 23 * * ?")
    public void checkFiles(){
        log.info("File Check!!!");
        log.info("----------------------");

//       이전 파일 리스트를 뽑아온다.
        List<IntProfileDto> oldList = mypageService.findOldProfilePhoto();

        List<Path> fileListPaths = new ArrayList<>();
        for (IntProfileDto dto : oldList){
            String name = dto.getUserProfileName();
            String uuid = dto.getUserProfileUuid();
            String uploadPath = dto.getUserProfileUploadPath();

            Path path = Paths.get(fileDir, uploadPath, uuid + "_" + name);
            fileListPaths.add(path);
        }



//      이전 파일들이 들어있는 경로(파일이름을 제외한)를 파일객체로 저장한다.
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String oldUploadPath = now.format(formatter);

        File directory = Paths.get(fileDir, oldUploadPath).toFile();

//      File 객체는 폴더안에 있는 모든 파일 목록을 불러오는 기능이 있다. -> listFiles()이다.
//      불러온 파일들을 file 매개변수로 받아 DB에서 가져온 fileListPaths 리스트에 존재하는지
//      검사하고 DB에 존재하지 않는 파일이면 삭제한다.
        File[] files = directory.listFiles(file -> !fileListPaths.contains(file.toPath()));

        if (files == null){
            return;
        }
        for (File file: files){
            log.info(file.getPath() + "delete !!!!");
            file.delete();
        }
    }


}
