package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultDeclAdminDto;
import com.example.hippobookproject.dto.administrator.ResultPostInfoDto;
import com.example.hippobookproject.dto.administrator.SelectDeclAdminDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdministratorDeclMapper {
    List<ResultDeclAdminDto> selectDeclList(@Param("selectDecl") SelectDeclAdminDto selectDeclAdminDto,
                                            @Param("criteria") AdminUserCriteria adminDeclCriteria);

    List<ResultDeclAdminDto> selectCommentDecl(@Param("selectDecl") SelectDeclAdminDto selectDeclAdminDto,
                                            @Param("criteria") AdminUserCriteria adminDeclCriteria);

    List<ResultDeclAdminDto> selectFeedDeclList(@Param("selectDecl") SelectDeclAdminDto selectDeclAdminDto,
                                               @Param("criteria") AdminUserCriteria adminDeclCriteria);
    int selectDeclTotal(@Param("selectDecl") SelectDeclAdminDto selectDeclAdminDto);

    int selectCommentDeclTotal(@Param("selectDecl") SelectDeclAdminDto selectDeclAdminDto);

    int selectFDeclTotal(@Param("selectDecl") SelectDeclAdminDto selectDeclAdminDto);

    Optional<ResultPostInfoDto> selectDealDecl(Long postId);
    Optional<ResultPostInfoDto> selectBoardDecl(Long postId);
    Optional<ResultPostInfoDto> selectNovelDecl(Long postId);
    Optional<ResultPostInfoDto> selectClaimDecl(Long postId);

    Optional<ResultPostInfoDto> selectDealCMDecl(Long commentId);
    Optional<ResultPostInfoDto> selectBoardCMDecl(Long commentId);
    Optional<ResultPostInfoDto> selectNovelCMDecl(Long commentId);
    Optional<ResultPostInfoDto> selectClaimCMDecl(Long commentId);
    Optional<ResultPostInfoDto> selectBookCMDecl(Long commentId);
    Optional<ResultPostInfoDto> selectFeedDecl(Long feedId);

    void deleteDeclaration(Long declId);

    void deleteCMDeclaration(Long declId);
    void deleteFDeclaration(Long declId);

    void deleteDealDecl(Long postId);
    void deleteBoardDecl(Long postId);
    void deleteNovelDecl(Long postId);
    void deleteClaimDecl(Long postId);

    void deleteDealCMDecl(Long commentId);
    void deleteBoardCMDecl(Long commentId);
    void deleteNovelCMDecl(Long commentId);
    void deleteClaimCMDecl(Long commentId);
    void deleteBookCMDecl(Long commentId);
}
