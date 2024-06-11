package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.dto.mypage.IntBoardDto;
import com.example.hippobookproject.dto.mypage.IntProfileDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MypageBookContainerMapperTest {
    @Autowired
    MypageBookContainerMapper mypageBookContainerMapper;

    BookContainerDto bookContainerDto;

    IntProfileDto intProfileDto;

    @Test
    void selectBookContainer() {

        List<BookContainerDto> bookContainerList = mypageBookContainerMapper.selectBookContainer(1L);
    }

    @Test
    void deleteBookHas(){
        //given
        List<BookContainerDto> bookContainerDtoList = mypageBookContainerMapper.selectBookContainer(1L);
        //System.out.println("bookContainerDtoList = " + bookContainerDtoList);
        //when

        int oldSize = bookContainerDtoList.size();
        BookContainerDto bookContainerDto = bookContainerDtoList.get(0);
            //System.out.println("bookContainerDto = " + bookContainerDto);
        Long bookHasId = bookContainerDto.getBookHasId();
        mypageBookContainerMapper.deleteBookHas(bookHasId);

        List<BookContainerDto> list = mypageBookContainerMapper.selectBookContainer(1L);
        //then
//        Assertions.assertThat(bookContainerDto).isNull();
        assertThat(list.size()).isEqualTo(oldSize - 1);
    }



    @Test
    void selectBestBook(){
        Optional<BookContainerDto> bookContainerDto = mypageBookContainerMapper.selectBestBook(1L);
        System.out.println("bookContainerDto = " + bookContainerDto);

    }

    @Test
    void updateBestBook(){
        // given
        BookContainerDto bookContainerDto = new BookContainerDto();
        bookContainerDto.setUserId(1L);
        bookContainerDto.setBookHasId(3L);
        // when
        mypageBookContainerMapper.updateBestBook(bookContainerDto);
        mypageBookContainerMapper.selectBestBook(1L).orElse(null);

        // then

        assertThat(bookContainerDto)
                .extracting("bookHasId")
                .isEqualTo(bookContainerDto.getBookHasId());

    }

    @Test
    void updateBookStatus(){
        // given
        // when
        mypageBookContainerMapper.updateBookStatus(bookContainerDto);
        bookContainerDto = new BookContainerDto();
        // then
        assertThat(bookContainerDto)
                .extracting("bookHasPercent")
                .isEqualTo(bookContainerDto.getBookHasPercent());

    }

}