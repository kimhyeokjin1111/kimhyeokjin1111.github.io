package com.example.hippobookproject.service.administrator;

import com.example.hippobookproject.dto.administrator.ResultNoticeDto;
import com.example.hippobookproject.mapper.administrator.AdministratorHeaderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdministratorHeaderService {
    private final AdministratorHeaderMapper administratorHeaderMapper;
    public List<ResultNoticeDto> findDeclAll() {
        return administratorHeaderMapper.selectDeclAll();
    }

    public List<ResultNoticeDto> findStickerAll() {
        return administratorHeaderMapper.selectStickerAll();
    }

    public List<ResultNoticeDto> findNoticeAll() {
        return  administratorHeaderMapper.selectNoticeAll();
    }

    public void modifyPDeclByIds(List<Integer> idList){
        administratorHeaderMapper.updatePDeclByIds(idList);
    }

    public void modifyCDeclByIds(List<Integer> idList){
        administratorHeaderMapper.updateCDeclByIds(idList);
    }

    public void modifyFDeclByIds(List<Integer> idList){
        administratorHeaderMapper.updateFDeclByIds(idList);
    }

    public void modifyStickerByIds(List<Integer> idList){
        administratorHeaderMapper.updateStickerByIds(idList);
    }

}
