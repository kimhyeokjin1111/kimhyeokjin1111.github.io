package com.example.hippobookproject.mapper.book;
import com.example.hippobookproject.dto.Categorie.BookDto;
import com.example.hippobookproject.dto.book.AladinItemDto;
import com.example.hippobookproject.dto.book.BookCommentWriteDto;
import com.example.hippobookproject.dto.book.BookHasWriteDto;
import com.example.hippobookproject.dto.book.BookInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;
import java.util.Set;

@Mapper
public interface BookMapper {
    void insertBook(BookDto book);
    void updateBook(BookDto book);
    BookDto findBookById(Long bookId);
    void deleteBook(BookDto book);

    void insertAllBook(AladinItemDto aladinItemDto);

    Set<String> selectIsbn();

    Optional<BookInfoDto> selectBookInfo(Long bookId);

    void insertBookHas(BookHasWriteDto bookHasWriteDto);
    int selectBookHas(Long bookId,
                      Long userId);

    void insertBookComment(BookCommentWriteDto bookCommentWriteDto);

    int selectBookCommentAll(Long bookId);
}
