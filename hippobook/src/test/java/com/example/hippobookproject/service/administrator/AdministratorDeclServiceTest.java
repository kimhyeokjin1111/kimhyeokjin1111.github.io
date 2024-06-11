package com.example.hippobookproject.service.administrator;

import com.example.hippobookproject.dto.administrator.ResultPostInfoDto;
import com.example.hippobookproject.mapper.administrator.AdministratorDeclMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AdministratorDeclServiceTest {
    @Mock
    AdministratorDeclMapper administratorDeclMapper;

    @InjectMocks
    AdministratorDeclService administratorDeclService;

    @Test
    void findPostDecl() {
        //given
        ResultPostInfoDto resultPostInfoDto = new ResultPostInfoDto();
        resultPostInfoDto.setPostContent("test post content");

        doReturn(Optional.of(resultPostInfoDto)).when(administratorDeclMapper).selectDealDecl(any());
        //when
        ResultPostInfoDto ResultPostInfoDto = administratorDeclService.findPostDecl(1L, "deal");
        //then
        assertThat(ResultPostInfoDto)
                .extracting("postContent")
                .isEqualTo("test post content");

    }
}