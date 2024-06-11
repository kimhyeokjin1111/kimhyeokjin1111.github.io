package com.example.hippobookproject.dto.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString

public class MessageCriteria {
    private  int page; // 현재 페이지
    private  int amount; // 한 페이지 당 게시물 수

    public MessageCriteria() {

//        this.page = 1;
//        this.amount = 9;
        this(1,9);

    }

    public MessageCriteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }
}
