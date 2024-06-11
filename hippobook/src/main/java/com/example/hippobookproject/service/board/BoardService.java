package com.example.hippobookproject.service.board;

import com.example.hippobookproject.dto.board.PostSearchResultDto;
import com.example.hippobookproject.dto.board.PostViewDto;
import com.example.hippobookproject.mapper.board.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public PostSearchResultDto selectPostById(Long postId, String postType){
        log.info("postId = " + postId + ", postType@@@@@@@@ = " + postType);
        switch (postType){
            case "deal":
                return boardMapper.selectDeclById(postId);
            case "board":
                return boardMapper.selectBoardById(postId);
            case "novel":
                return boardMapper.selectNovelById(postId);
            default:
                return boardMapper.selectClaimById(postId);
        }
    }

    public void registerPostView(Long postId, Long userId, String postType){
        int viewCnt;

        PostViewDto postViewDto = new PostViewDto();
        postViewDto.setPostId(postId);
        postViewDto.setUserId(userId);

        switch (postType){
            case "deal":
                viewCnt = boardMapper.selectDealView(postViewDto);
                log.info("viewCnt deal~~~~~~~~~~~~~ = {}", viewCnt);
                if(viewCnt != 1) {
                    boardMapper.insertDealView(postViewDto);
                    break;
                }
            case "board":
                viewCnt = boardMapper.selectBoardView(postViewDto);
                if(viewCnt != 1) {
                    boardMapper.insertBoardView(postViewDto);
                    break;
                }
                break;
            case "novel":
                viewCnt = boardMapper.selectNovelView(postViewDto);
                if(viewCnt != 1) {
                    boardMapper.insertNovelView(postViewDto);
                    break;
                }
                break;
            default:
                viewCnt = boardMapper.selectClaimView(postViewDto);
                if(viewCnt != 1) {
                    boardMapper.insertClaimView(postViewDto);
                    break;
                }
                break;
        }
    }
}
