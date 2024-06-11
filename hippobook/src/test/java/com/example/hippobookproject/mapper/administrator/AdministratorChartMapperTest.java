package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultChartAdminDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AdministratorChartMapperTest {
    @Autowired
    AdministratorChartMapper administratorChartMapper;

    @Test
    void selectVisitByRange(){
        List<ResultChartAdminDto> resultChartAdminDtos = administratorChartMapper.selectVisitByRange(1);

        assertThat(resultChartAdminDtos).hasSize(2);
    }
}