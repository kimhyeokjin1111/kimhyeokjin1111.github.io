package com.example.hippobookproject.service.administrator;

import com.example.hippobookproject.dto.administrator.ResultChartAdminDto;
import com.example.hippobookproject.mapper.administrator.AdministratorChartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdministratorChartService {
    private final AdministratorChartMapper administratorChartMapper;

    public List<ResultChartAdminDto> findVisitByRange(int term){
        return administratorChartMapper.selectVisitByRange(term);
    }
}
