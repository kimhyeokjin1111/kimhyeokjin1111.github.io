package com.example.hippobookproject.service.board;

import com.example.hippobookproject.dto.board.PostSearchOptDto;
import com.example.hippobookproject.dto.board.PostSearchResultDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.mapper.board.BoardMainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardMainService {
    private final BoardMainMapper boardMainMapper;

    public List<PostSearchResultDto> findPost(PostSearchOptDto postSearchOptDto,
                                              AdminUserCriteria criteria,
                                              String postType){
        switch (postType){
            case "deal":
                return boardMainMapper.selectDealPost(postSearchOptDto, criteria);
            case "board":
                return boardMainMapper.selectBoardPost(postSearchOptDto, criteria);
            case "novel":
                return boardMainMapper.selectNovelPost(postSearchOptDto, criteria);
            default:
                return boardMainMapper.selectClaimPost(postSearchOptDto, criteria);
        }

    }

    public int findPostTotal(PostSearchOptDto postSearchOptDto,
                               String postType){
        switch (postType){
            case "deal":
                return boardMainMapper.selectDeclPostTotal(postSearchOptDto);
            case "board":
                return boardMainMapper.selectBoardPostTotal(postSearchOptDto);
            case "novel":
                return boardMainMapper.selectNovelPostTotal(postSearchOptDto);
            default:
                return boardMainMapper.selectClaimPostTotal(postSearchOptDto);
        }

    }

}
