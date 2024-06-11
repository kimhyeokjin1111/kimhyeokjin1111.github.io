package com.example.hippobookproject.service.like;

import com.example.hippobookproject.dto.like.PostLikeWriteDto;
import com.example.hippobookproject.mapper.like.LikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LikeService {
    private final LikeMapper likeMapper;

    public void registerPostLike(String postType, PostLikeWriteDto postLikeWriteDto){
        switch (postType) {
            case "deal":
                likeMapper.insertDealLike(postLikeWriteDto);
                break;
            case "board":
                likeMapper.insertBoardLike(postLikeWriteDto);
                break;
            case "novel":
                likeMapper.insertNovelLike(postLikeWriteDto);
                break;
            case "claim":
                likeMapper.insertClaimLike(postLikeWriteDto);
                break;
        }
    }

    public int findPostLike(String postType, Long postId){
        switch (postType) {
            case "deal":
                return likeMapper.selectDealLike(postId);
            case "board":
                return likeMapper.selectBoardLike(postId);
            case "novel":
                return likeMapper.selectNovelLike(postId);
            default:
                return likeMapper.selectClaimLike(postId);
        }
    }
}
