package com.example.hippobookproject.dto.administrator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter @Setter @ToString
@NoArgsConstructor
public class SelectUserAdminDto {
    private String userInfo;
    private String userInfoDate;
    private LocalDate startJoinDate;
    private LocalDate endJoinDate;
    private Integer startUserAge;
    private Integer endUserAge;
    private String gender;
    private LocalDate startVisitDate;
    private LocalDate endVisitDate;

    public String getStartJoinDateValue(){
        if (this.startJoinDate == null){
            return null;
        }
        return this.startJoinDate.format(DateTimeFormatter.ISO_DATE);
    }

    public String getEndJoinDateValue(){
        if (this.endJoinDate == null){
            return null;
        }
        return this.endJoinDate.format(DateTimeFormatter.ISO_DATE);
    }
}
