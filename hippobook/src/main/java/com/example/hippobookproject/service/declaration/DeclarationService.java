package com.example.hippobookproject.service.declaration;

import com.example.hippobookproject.dto.declaration.WriteDeclDto;
import com.example.hippobookproject.mapper.declaration.DeclarationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeclarationService {
    private final DeclarationMapper declarationMapper;

    public void registerDecl(String declType, WriteDeclDto writeDeclDto){
        switch (declType) {
            case "post":
                declarationMapper.insertPostDecl(writeDeclDto);
                break;
            case "comment":
                declarationMapper.insertCommentDecl(writeDeclDto);
                break;
            case "feed":
                declarationMapper.insertFeedDecl(writeDeclDto);
                break;
        }
    }
}
