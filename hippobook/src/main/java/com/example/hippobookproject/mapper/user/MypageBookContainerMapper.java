package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.dto.mypage.IntBoardDto;
import com.example.hippobookproject.dto.mypage.IntProfileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MypageBookContainerMapper {
    List<BookContainerDto> selectBookContainer(Long userId);

    void deleteBookHas(Long bookHasId);

    void updateBestBook(BookContainerDto bookContainerDto);

    Optional<BookContainerDto> selectBestBook(Long userId);

    void updateBookStatus(BookContainerDto bookContainerDto);
}
