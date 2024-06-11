package com.example.hippobookproject.mapper.categorie;
import com.example.hippobookproject.dto.Categorie.BookCateDto;
import com.example.hippobookproject.mapper.book.BookCateMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
@Transactional
class BookCateMapperTest {
    @Autowired
    private BookCateMapper bookCateMapper;
    private BookCateDto BookCate;
    @BeforeEach
    void setUp() {
        BookCate = new BookCateDto();
        BookCate.setBookCateId(1L);
        BookCate.setCateId(1L);
        BookCate.setBookId(1L);
    }
    @Test
    void insertBookCate() {
        bookCateMapper.insertBookCate(BookCate);
        BookCateDto insertBookCate = bookCateMapper.findBookCateById(BookCate.getCateId());
        assertNotNull(insertBookCate);
        assertEquals(insertBookCate.getBookCateId(), BookCate.getBookCateId());
        assertEquals(insertBookCate.getBookId(), BookCate.getBookId());
        assertEquals(insertBookCate.getCateId(), BookCate.getCateId());
    }
    @Test
    void updateBookCate(){
        bookCateMapper.updateBookCate(BookCate);
        BookCateDto updateBookCate = bookCateMapper.findBookCateById(BookCate.getCateId());
        assertNotNull(updateBookCate);
        assertEquals(updateBookCate.getCateId(), BookCate.getCateId());
        assertEquals(updateBookCate.getBookCateId(), BookCate.getBookCateId());
        assertEquals(updateBookCate.getBookId(), BookCate.getBookId());
    }
    @Test
    void deleteBookCate(){
        bookCateMapper.deleteBookCate(BookCate);
        BookCateDto deleteBookCate = bookCateMapper.findBookCateById(BookCate.getCateId());
        assertNotNull(deleteBookCate);
        assertEquals(deleteBookCate.getCateId(), BookCate.getCateId());
        assertEquals(deleteBookCate.getBookCateId(), BookCate.getBookCateId());
        assertEquals(deleteBookCate.getBookId(), BookCate.getBookId());
    }
}