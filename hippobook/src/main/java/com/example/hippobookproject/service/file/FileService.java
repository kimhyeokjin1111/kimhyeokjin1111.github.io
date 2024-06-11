package com.example.hippobookproject.service.file;

import com.example.hippobookproject.mapper.file.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FileService {
    private final FileMapper fileMapper;
}
