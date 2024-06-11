package com.example.hippobookproject.dto.administrator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class ResultUserAdminDto {
    private Long userId;
    private String userName;
    private String userLoginId;
    private String userPhonenumber;
    private String userGender;
    private String userAge;
    private String userEmail;
    private String userAddress;
    private String userAddressDetail;
    private String userZipcode;
}
