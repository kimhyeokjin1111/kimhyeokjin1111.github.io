package com.example.hippobookproject.batch;

import com.example.hippobookproject.dto.book.AladinApiDto;
import com.example.hippobookproject.dto.book.AladinItemDto;
import com.example.hippobookproject.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ApiItemReader implements ItemReader<AladinItemDto> {
    private final BookService bookService;

    private int nextIdx = 0;
    private List<AladinItemDto> items;

    @Override
    public AladinItemDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {


        if (items == null) {
            items = new ArrayList<>();
            for (int i = 1; i < 20; i++) {
                AladinApiDto allBook = bookService.findAllBook(i);
                items.addAll(allBook.getItem());
            }
        }

        AladinItemDto nextItemDto = null;

        if (nextIdx < items.size()) {
            nextItemDto = items.get(nextIdx);
            nextIdx++;
        } else {
            items = null;
            nextIdx = 0;
        }

        return nextItemDto;

    }
}
