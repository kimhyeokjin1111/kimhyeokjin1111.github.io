package com.example.hippobookproject.mapper.book;
import com.example.hippobookproject.dto.Categorie.BookCateDto;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface BookCateMapper {
    void updateBookCate(BookCateDto bookCateDto);
    BookCateDto findBookCateById(Long bookCateId);
    void insertBookCate(BookCateDto BookCate);
    void deleteBookCate(BookCateDto bookCate);
}
