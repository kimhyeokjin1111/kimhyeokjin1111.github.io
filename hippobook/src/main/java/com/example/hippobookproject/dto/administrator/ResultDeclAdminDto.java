package com.example.hippobookproject.dto.administrator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
@NoArgsConstructor
public class ResultDeclAdminDto {
//    POST_DECLARATION_ID, POST_DECLARATION_DATE, POST_DECLARATION_CONTENT,
//    USER_ID, POST_DECLARATION_CHECK, POST_ID, POST_CATE,  POST_DECLARATION_PROCESS_DATE
    Long DeclarationId;
    LocalDate DeclarationDate;
    String DeclarationContent;
    Long userId;
    String nickname;
    String DeclarationCheck;
    Long typeId;
    String cate;
    LocalDate DeclProcessDate;
}
