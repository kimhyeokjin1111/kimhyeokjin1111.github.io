package com.example.hippobookproject.mapper.categorie;
import com.example.hippobookproject.dto.Categorie.BookDto;
import com.example.hippobookproject.mapper.book.BookMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
@Transactional
class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;
    private BookDto Book;
    @BeforeEach
    void setUp(){
        Book = new BookDto();
        Book.setBookName("Book");
        Book.setBookWriter("Writer");
        Book.setBookDate(1L);
        Book.setBookId(1L);
        Book.setPublisherId(1L);
    }
    @Test
    void insertBook(){
        bookMapper.insertBook(Book);
        BookDto insertBook = bookMapper.findBookById(Book.getBookId());
        assertNotNull(insertBook);
        assertEquals(insertBook.getBookName(), Book.getBookName());
        assertEquals(insertBook.getBookId(), Book.getBookId());
        assertEquals(insertBook.getBookWriter(), Book.getBookWriter());
        assertEquals(insertBook.getBookDate(), Book.getBookDate());
        assertEquals(insertBook.getPublisherId(), Book.getPublisherId());
    }
    @Test
    void updateBook(){
        bookMapper.updateBook(Book);
        BookDto updateBook = bookMapper.findBookById(Book.getBookId());
        assertNotNull(updateBook);
        assertEquals(updateBook.getBookName(), Book.getBookName());
        assertEquals(updateBook.getBookId(), Book.getBookId());
        assertEquals(updateBook.getBookWriter(), Book.getBookWriter());
        assertEquals(updateBook.getBookDate(), Book.getBookDate());
        assertEquals(updateBook.getPublisherId(), Book.getPublisherId());
    }
    @Test
    void deleteBook(){
        bookMapper.deleteBook(Book);
        BookDto deleteBook = bookMapper.findBookById(Book.getBookId());
        assertNotNull(deleteBook);
        assertEquals(deleteBook.getBookName(), Book.getBookName());
        assertEquals(deleteBook.getBookId(), Book.getBookId());
        assertEquals(deleteBook.getBookWriter(), Book.getBookWriter());
        assertEquals(deleteBook.getBookDate(), Book.getBookDate());
        assertEquals(deleteBook.getPublisherId(), Book.getPublisherId());
    }

    @Test
    void selectIsbn(){
        Set<String> strings = bookMapper.selectIsbn();
        System.out.println("strings = " + strings);

        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        System.out.println(integers.contains(1));

        System.out.println(strings.contains("K832930683"));

    }
}