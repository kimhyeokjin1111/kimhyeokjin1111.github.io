package com.example.hippobookproject.service.feed;

import com.example.hippobookproject.dto.feed.CardDto;
import com.example.hippobookproject.dto.feed.PostBookDto;
import com.example.hippobookproject.dto.feed.PostSearchDto;
import com.example.hippobookproject.mapper.feed.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;

    public List<PostBookDto> selectAll(){
        return postMapper.selectAll();
    }

    public List<PostBookDto> selectByKeyword(PostSearchDto postSearchDto){
        return postMapper.selectByKeyword(postSearchDto);
    }
}
