package com.example.hippobookproject.service.administrator;

import com.example.hippobookproject.dto.administrator.ResultDeclAdminDto;
import com.example.hippobookproject.dto.administrator.ResultPostInfoDto;
import com.example.hippobookproject.dto.administrator.SelectDeclAdminDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.mapper.administrator.AdministratorDeclMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdministratorDeclService {
    private final AdministratorDeclMapper administratorDeclMapper;
    public List<ResultDeclAdminDto> findDeclList(SelectDeclAdminDto selectDeclAdminDto,
                                            AdminUserCriteria adminDeclCriteria) {
        return administratorDeclMapper.selectDeclList(selectDeclAdminDto, adminDeclCriteria);
    }

    public List<ResultDeclAdminDto> findCommentDecl(SelectDeclAdminDto selectDeclAdminDto,
                                                 AdminUserCriteria adminDeclCriteria) {
        return administratorDeclMapper.selectCommentDecl(selectDeclAdminDto, adminDeclCriteria);
    }

    public List<ResultDeclAdminDto> findFeedDeclList(SelectDeclAdminDto selectDeclAdminDto,
                                                    AdminUserCriteria adminDeclCriteria) {
        return administratorDeclMapper.selectFeedDeclList(selectDeclAdminDto, adminDeclCriteria);
    }

    public int findDeclTotal(SelectDeclAdminDto selectDeclAdminDto) {
        return administratorDeclMapper.selectDeclTotal(selectDeclAdminDto);
    }

    public int findFDeclTotal(SelectDeclAdminDto selectDeclAdminDto) {
        return administratorDeclMapper.selectFDeclTotal(selectDeclAdminDto);
    }

    public int findCommentDeclTotal(SelectDeclAdminDto selectDeclAdminDto) {
        return administratorDeclMapper.selectCommentDeclTotal(selectDeclAdminDto);
    }

    public ResultPostInfoDto findPostDecl(Long postId, String cate){
        Optional<ResultPostInfoDto> resultPostInfoDto = Optional.empty();

        if("deal".equals(cate)){
            resultPostInfoDto = administratorDeclMapper.selectDealDecl(postId);
        }else if("board".equals(cate)){
            resultPostInfoDto = administratorDeclMapper.selectBoardDecl(postId);
        }else if("novel".equals(cate)){
            resultPostInfoDto = administratorDeclMapper.selectNovelDecl(postId);
        }else if("claim".equals(cate)){
            resultPostInfoDto = administratorDeclMapper.selectClaimDecl(postId);
        }

        return resultPostInfoDto.orElseThrow(() -> new IllegalStateException("해당 게시물이 존재하지 않음"));
    }

    public ResultPostInfoDto findCommentDecl(Long commentId, String cate){
        Optional<ResultPostInfoDto> resultPostInfoDto = Optional.empty();

        if("deal".equals(cate)){
            System.out.println("deal comment in~~~~~~~~~~~~~");
            resultPostInfoDto = administratorDeclMapper.selectDealCMDecl(commentId);
        }else if("board".equals(cate)){
            resultPostInfoDto = administratorDeclMapper.selectBoardCMDecl(commentId);
        }else if("novel".equals(cate)){
            resultPostInfoDto = administratorDeclMapper.selectNovelCMDecl(commentId);
        }else if("claim".equals(cate)){
            resultPostInfoDto = administratorDeclMapper.selectClaimCMDecl(commentId);
        } else if("book".equals(cate)){
            resultPostInfoDto = administratorDeclMapper.selectBookCMDecl(commentId);
        }

        return resultPostInfoDto.orElseThrow(() -> new IllegalStateException("해당 코멘트가 존재하지 않음"));
    }

    public ResultPostInfoDto findFeedDecl(Long feedId){
        Optional<ResultPostInfoDto> resultFeedInfoDto = administratorDeclMapper.selectFeedDecl(feedId);
        return resultFeedInfoDto.orElseThrow(() -> new IllegalStateException("해당 피드가 존재하지 않음"));
    }

    public void removeDecl(Long declId) {
        administratorDeclMapper.deleteDeclaration(declId);
    };

    public void removeCMDeclaration(Long declId){
        administratorDeclMapper.deleteCMDeclaration(declId);
    };
    public void removeFDeclaration(Long declId){
        administratorDeclMapper.deleteFDeclaration(declId);
    };

    public void deletePostDecl(Long postId, String postType){
        if("deal".equals(postType)){
            administratorDeclMapper.deleteDealDecl(postId);
        }else if("board".equals(postType)){
            administratorDeclMapper.deleteBoardDecl(postId);
        }else if("novel".equals(postType)){
            administratorDeclMapper.deleteNovelDecl(postId);
        }else if("claim".equals(postType)){
            administratorDeclMapper.deleteClaimDecl(postId);
        }
    }

    public void deleteCommentDecl(Long commentId, String commentType){
        if("deal".equals(commentType)){
            administratorDeclMapper.deleteDealCMDecl(commentId);
        }else if("board".equals(commentType)){
            administratorDeclMapper.deleteBoardCMDecl(commentId);
        }else if("novel".equals(commentType)){
            administratorDeclMapper.deleteNovelCMDecl(commentId);
        }else if("claim".equals(commentType)){
            administratorDeclMapper.deleteClaimCMDecl(commentId);
        }else if("book".equals(commentType)){
            administratorDeclMapper.deleteBookCMDecl(commentId);
        }
    }
}
