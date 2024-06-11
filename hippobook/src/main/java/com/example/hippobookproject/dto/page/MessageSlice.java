package com.example.hippobookproject.dto.page;

import lombok.*;

import java.util.List;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class MessageSlice<T> {
    boolean hasNext;
    List<T> contentList;

}
