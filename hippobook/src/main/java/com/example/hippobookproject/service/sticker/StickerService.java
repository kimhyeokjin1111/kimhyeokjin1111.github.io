package com.example.hippobookproject.service.sticker;

import com.example.hippobookproject.mapper.sticker.StickerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StickerService {
    private final StickerMapper stickerMapper;
}
