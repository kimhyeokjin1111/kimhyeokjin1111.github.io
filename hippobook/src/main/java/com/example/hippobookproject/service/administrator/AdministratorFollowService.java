package com.example.hippobookproject.service.administrator;

import com.example.hippobookproject.dto.administrator.ResultStickerDto;
import com.example.hippobookproject.dto.administrator.SelectStickerDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.mapper.administrator.AdministratorStickerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AdministratorFollowService {
    private final AdministratorStickerMapper administratorStickerMapper;

    public List<ResultStickerDto> findStickerReqList(SelectStickerDto selectStickerDto,
                                                     AdminUserCriteria criteria){
        return administratorStickerMapper.selectStickerReqList(selectStickerDto, criteria);
    }

    public int findFollowReqTotal(SelectStickerDto selectStickerDto){
        return administratorStickerMapper.selectFollowReqTotal(selectStickerDto);
    }

    public void modifyUserStickerCheck(List<Integer> idList){
        administratorStickerMapper.updateUserStickerCheck(idList);
    }
}
