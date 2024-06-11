package com.example.hippobookproject.mapper.declaration;

import com.example.hippobookproject.dto.declaration.WriteDeclDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DeclarationMapperTest {

    @Autowired
    DeclarationMapper declarationMapper;

    WriteDeclDto writeDeclDto;
    @BeforeEach
    void setUp() {
        writeDeclDto = new WriteDeclDto();
        writeDeclDto.setDeclContent("test feed decl ssss");
        writeDeclDto.setDeclCate("board");
        writeDeclDto.setTargetId(1L);
        writeDeclDto.setUserId(1L);
    }

    @Test
    void insertPostDecl() {
        declarationMapper.insertPostDecl(writeDeclDto);
    }

    @Test
    void insertFeedDecl() {
        declarationMapper.insertFeedDecl(writeDeclDto);
    }
}