package com.example.hippobookproject.dto.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AladinApiDto {
    private String version;
    private String logo;
    private String title;
    private String pubDate;
    private Long totalResults;
    private int startIndex;
    private int itemsPerPage;
    private List<AladinItemDto> item;
}
