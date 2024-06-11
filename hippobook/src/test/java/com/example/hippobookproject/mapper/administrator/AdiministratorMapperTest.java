package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultUserAdminDto;
import com.example.hippobookproject.dto.administrator.SelectUserAdminDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AdiministratorMapperTest {
    @Autowired
    AdiministratorUserMapper adiministratorMapper;

    SelectUserAdminDto selectUserAdminDto;
    AdminUserCriteria criteria;
    @BeforeEach
    void setUp() {
        selectUserAdminDto = new SelectUserAdminDto();
        selectUserAdminDto.setUserInfo("loginId");
        selectUserAdminDto.setUserInfoDate("a");
        selectUserAdminDto.setStartJoinDate(LocalDate.parse("2024-04-30", DateTimeFormatter.ISO_DATE));
        selectUserAdminDto.setEndJoinDate(LocalDate.parse("2024-05-01", DateTimeFormatter.ISO_DATE));
        selectUserAdminDto.setStartUserAge(21);
        selectUserAdminDto.setEndUserAge(23);
        selectUserAdminDto.setGender("M");
        selectUserAdminDto.setStartVisitDate(LocalDate.parse("2024-04-30", DateTimeFormatter.ISO_DATE));
        selectUserAdminDto.setEndVisitDate(LocalDate.parse("2024-05-01", DateTimeFormatter.ISO_DATE));

        criteria = new AdminUserCriteria(1, 10);

        List<ResultUserAdminDto> resultUserAdminDtos = adiministratorMapper.selectUserAdmin(selectUserAdminDto , criteria);

        assertThat(resultUserAdminDtos).hasSize(1);
    }

    @Test
    void selectUserAdmin() {

    }

    @Test
    void selectUserAdminTotel(){
        SelectUserAdminDto selectDto = new SelectUserAdminDto();
        int i = adiministratorMapper.selectAdminUserTotal(selectDto);
        assertThat(i).isEqualTo(38);
    }

    @Test
    void deleteUserAdminById(){
        List<Integer> list = List.of(55,56);
        adiministratorMapper.deleteUserAdminById(list);
        SelectUserAdminDto selectDto = new SelectUserAdminDto();
        int i = adiministratorMapper.selectAdminUserTotal(selectDto);
        assertThat(i).isEqualTo(36);
    }

}