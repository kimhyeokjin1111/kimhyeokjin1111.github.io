package com.example.hippobookproject.mapper.declaration;

import com.example.hippobookproject.dto.declaration.WriteDeclDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeclarationMapper {
    void insertPostDecl(WriteDeclDto writeDeclDto);
    void insertCommentDecl(WriteDeclDto writeDeclDto);
    void insertFeedDecl(WriteDeclDto writeDeclDto);
}
