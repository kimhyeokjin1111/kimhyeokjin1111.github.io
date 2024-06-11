package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultDeclAdminDto;
import com.example.hippobookproject.dto.administrator.ResultPostInfoDto;
import com.example.hippobookproject.dto.administrator.SelectDeclAdminDto;
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
class AdministratorDeclMapperTest {
    @Autowired
    AdministratorDeclMapper administratorDeclMapper;

    SelectDeclAdminDto selectDeclAdminDto;
    AdminUserCriteria criteria;
    @BeforeEach
    void setUp() {
        selectDeclAdminDto = new SelectDeclAdminDto();
        selectDeclAdminDto.setDeclarationContent("test");
        selectDeclAdminDto.setStartDeclarationDate(LocalDate.parse("2024-05-14", DateTimeFormatter.ISO_DATE));
        selectDeclAdminDto.setEndDeclarationDate(LocalDate.parse("2024-05-14", DateTimeFormatter.ISO_DATE));
        selectDeclAdminDto.setStartPocecssDate(LocalDate.parse("2024-05-14", DateTimeFormatter.ISO_DATE));
        selectDeclAdminDto.setEndPocecssDate(LocalDate.parse("2024-05-14", DateTimeFormatter.ISO_DATE));
        selectDeclAdminDto.setDeclarationType("board");
        selectDeclAdminDto.setProcessType("");

        criteria = new AdminUserCriteria();
        criteria.setPage(1);
        criteria.setAmount(10);
    }

    @Test
    void selectDeclList() {
        List<ResultDeclAdminDto> resultDeclAdminDtos = administratorDeclMapper.selectDeclList(selectDeclAdminDto, criteria);
        assertThat(resultDeclAdminDtos)
                .hasSize(5)
                .extracting("declarationContent")
                .isEqualTo("test");
    }

    @Test
    void selectCommentDecl(){
        List<ResultDeclAdminDto> resultDeclAdminDtos = administratorDeclMapper.selectCommentDecl(selectDeclAdminDto, criteria);
        assertThat(resultDeclAdminDtos)
                .extracting("DeclarationContent")
                .isEqualTo("comment decl test content");
    }

    @Test
    void selectDeclTotal() {
        int i = administratorDeclMapper.selectDeclTotal(selectDeclAdminDto);
        assertThat(i).isEqualTo(5);
    }

    @Test
    void selectCommentDeclTotal(){
        int i = administratorDeclMapper.selectCommentDeclTotal(selectDeclAdminDto);
        assertThat(i).isEqualTo(15);
    }

    @Test
    void selectBoardDecl(){
        ResultPostInfoDto resultPostInfoDto = administratorDeclMapper.selectBoardDecl(2L).get();
        assertThat(resultPostInfoDto)
                .extracting("postTitle")
                .isEqualTo("test board title2");
    }
    
    @Test
    void selectFeedDecl(){
        List<ResultDeclAdminDto> resultDeclAdminDtos = administratorDeclMapper.selectFeedDeclList(selectDeclAdminDto, criteria);
        assertThat(resultDeclAdminDtos)
                .extracting("DeclarationContent")
                .isEqualTo("test feed decl content");
    }

    @Test
    void deleteFDeclaration(){
        administratorDeclMapper.deleteFDeclaration(1L);

        List<ResultDeclAdminDto> resultDeclAdminDtos = administratorDeclMapper.selectFeedDeclList(selectDeclAdminDto, criteria);
        assertThat(resultDeclAdminDtos)
                .isEmpty();
    }
    
}