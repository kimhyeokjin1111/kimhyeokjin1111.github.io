package com.example.hippobookproject.dto.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @ToString @Setter
public class AdminUserCriteria {
    private int page;
    private int amount;

    public AdminUserCriteria() {
        this(1, 10);
    }

    public AdminUserCriteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }
}
