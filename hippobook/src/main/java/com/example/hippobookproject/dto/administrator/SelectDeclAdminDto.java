package com.example.hippobookproject.dto.administrator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SelectDeclAdminDto {
    private String declarationContent;
    private LocalDate startDeclarationDate;
    private LocalDate endDeclarationDate;
    private LocalDate startPocecssDate;
    private LocalDate endPocecssDate;
    private String declarationType;
    private String processType;

}
