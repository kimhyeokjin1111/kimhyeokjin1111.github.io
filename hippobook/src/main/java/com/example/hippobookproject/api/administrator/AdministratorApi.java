package com.example.hippobookproject.api.administrator;

import com.example.hippobookproject.dto.administrator.*;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.dto.page.AdminUserPage;
import com.example.hippobookproject.mapper.administrator.AdministratorHeaderMapper;
import com.example.hippobookproject.mapper.administrator.AdministratorStickerMapper;
import com.example.hippobookproject.service.administrator.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AdministratorApi {
    private final AdministratorUserService administratorUserService;
    private final AdministratorChartService administratorChartService;
    private final AdministratorDeclService administratorDeclService;
    private final AdministratorFollowService administratorFollowService;
    private final AdministratorHeaderService administratorHeaderService;

    @DeleteMapping("/v1/users")
    public void removeUserByIdList(@RequestParam(value="userIdList" , required = false)
                                   List<Integer> userIdList){
        log.info("userIdList = " + userIdList);
        if(userIdList != null){
            administratorUserService.removeUserAdminById(userIdList);
        }
    }

    @GetMapping("/v1/chart/attendances/{term}")
    public List<ResultChartAdminDto> searchAttendanceList(@PathVariable("term") int term){
        log.info("term = " + term);
        List<ResultChartAdminDto> visitByRange = administratorChartService.findVisitByRange(term);
        log.info("visitByRange = " + visitByRange);
        return visitByRange;
    }

    @GetMapping("/v1/declarations/post")
    public Map<String , Object> searchDeclarationList(SelectDeclAdminDto selectDeclAdminDto,
                                                          AdminUserCriteria adminDeclCriteria) {
        return createDeclMap(selectDeclAdminDto, adminDeclCriteria);
    }

    @GetMapping("/v1/declarations/comment")
    public Map<String , Object> searchDeclarationComment(SelectDeclAdminDto selectDeclAdminDto,
                                                      AdminUserCriteria adminDeclCriteria) {
        log.info("selectDeclAdminDto = " + selectDeclAdminDto + ", adminDeclCriteria = " + adminDeclCriteria);
        return createCommentDeclMap(selectDeclAdminDto, adminDeclCriteria);
    }

    @GetMapping("/v1/declarations/feed")
    public Map<String , Object> searchDeclarationFeed(SelectDeclAdminDto selectDeclAdminDto,
                                                         AdminUserCriteria adminDeclCriteria) {
        log.info("selectDeclAdminDto = " + selectDeclAdminDto + ", adminDeclCriteria = " + adminDeclCriteria);
        return createFeedDeclMap(selectDeclAdminDto, adminDeclCriteria);
    }

    public Map<String , Object> createFeedDeclMap(SelectDeclAdminDto selectDeclAdminDto,
                                              AdminUserCriteria adminDeclCriteria){
        log.info("selectDeclAdminDto = " + selectDeclAdminDto + ", adminDeclCriteria = " + adminDeclCriteria);
        List<ResultDeclAdminDto> declList = administratorDeclService.findFeedDeclList(selectDeclAdminDto, adminDeclCriteria);
        log.info("declList = {}", declList);
        int declTotal = administratorDeclService.findFDeclTotal(selectDeclAdminDto);
        AdminUserPage declPage = new AdminUserPage(adminDeclCriteria, declTotal);

        Map<String , Object> declMap = new HashMap<>();
        declMap.put("declList", declList);
        declMap.put("declPage", declPage);

        return declMap;
    }

    public Map<String , Object> createDeclMap(SelectDeclAdminDto selectDeclAdminDto,
                                              AdminUserCriteria adminDeclCriteria){
        log.info("selectDeclAdminDto = " + selectDeclAdminDto + ", adminDeclCriteria = " + adminDeclCriteria);
        List<ResultDeclAdminDto> declList = administratorDeclService.findDeclList(selectDeclAdminDto, adminDeclCriteria);
        log.info("declList = {}", declList);
        int declTotal = administratorDeclService.findDeclTotal(selectDeclAdminDto);
        AdminUserPage declPage = new AdminUserPage(adminDeclCriteria, declTotal);

        Map<String , Object> declMap = new HashMap<>();
        declMap.put("declList", declList);
        declMap.put("declPage", declPage);

        return declMap;
    }

    public Map<String , Object> createCommentDeclMap(SelectDeclAdminDto selectDeclAdminDto,
                                              AdminUserCriteria adminDeclCriteria){
        log.info("selectDeclAdminDto = " + selectDeclAdminDto + ", adminDeclCriteria = " + adminDeclCriteria);
        List<ResultDeclAdminDto> declList = administratorDeclService.findCommentDecl(selectDeclAdminDto, adminDeclCriteria);
        log.info("declList = {}", declList);
        int declTotal = administratorDeclService.findCommentDeclTotal(selectDeclAdminDto);
        AdminUserPage declPage = new AdminUserPage(adminDeclCriteria, declTotal);

        Map<String , Object> declMap = new HashMap<>();
        declMap.put("declList", declList);
        declMap.put("declPage", declPage);

        return declMap;
    }

    @GetMapping("/v1/post/{postId}")
    public ResultPostInfoDto searchPostInfo(@PathVariable("postId") Long postId,
                                            String cate){
        log.info("postId = " + postId + ", cate = " + cate);
        ResultPostInfoDto postDecl = administratorDeclService.findPostDecl(postId, cate);
        postDecl.setCate(cate);
        return postDecl;
    }

    @GetMapping("/v1/comment/{commentId}")
    public ResultPostInfoDto searchCommentInfo(@PathVariable("commentId") Long commentId,
                                            String cate){
        log.info("commentId = " + commentId + ", cate = " + cate);
        ResultPostInfoDto commentDecl = administratorDeclService.findCommentDecl(commentId, cate);
        log.info("commentDecl = {}", commentDecl);
        commentDecl.setCate(cate);
        return commentDecl;
    }

    @GetMapping("/v1/feed/{feedId}")
    public ResultPostInfoDto searchFeedInfo(@PathVariable("feedId") Long feedId){
        log.info("feedId = " + feedId);
        ResultPostInfoDto feedDecl = administratorDeclService.findFeedDecl(feedId);
        log.info("feedDecl = {}", feedDecl);
        feedDecl.setCate("feed");
        return feedDecl;
    }

    @DeleteMapping("/v1/declaration/post/{declId}")
    public void removeDeclById(@PathVariable("declId") Long declId){
        log.info("declId = " + declId);
        administratorDeclService.removeDecl(declId);
    };

    @DeleteMapping("/v1/declaration/comment/{declId}")
    public void removeCMDeclById(@PathVariable("declId") Long declId){
        log.info("declId = " + declId);
        administratorDeclService.removeCMDeclaration(declId);
    };
    @DeleteMapping("/v1/declaration/feed/{declId}")
    public void removeFDeclById(@PathVariable("declId") Long declId){
        log.info("declId = " + declId);
        administratorDeclService.removeFDeclaration(declId);
    };

    @GetMapping("/v1/admin/follow")
    public Map<String , Object> searchFollowSticker(SelectStickerDto selectStickerDto,
                                    AdminUserCriteria adminDeclCriteria){
        log.info("selectDeclAdminDto = " + selectStickerDto + ", adminDeclCriteria = " + adminDeclCriteria);
        List<ResultStickerDto> followList = administratorFollowService.findStickerReqList(selectStickerDto, adminDeclCriteria);
        log.info("followList = {}", followList);
        int followTotal = administratorFollowService.findFollowReqTotal(selectStickerDto);
        AdminUserPage stickerPage = new AdminUserPage(adminDeclCriteria, followTotal);
        log.info("stickerPage = {}", stickerPage);

        Map<String , Object> stickerMap = new HashMap<>();
        stickerMap.put("followList", followList);
        stickerMap.put("stickerPage", stickerPage);

        return stickerMap;
    }

    @GetMapping("/v1/admin/header/notice/{type}")
    public List<ResultNoticeDto> searchNoticeByType(@PathVariable("type") String type){
        switch (type){
            case "decl":
                return administratorHeaderService.findDeclAll();
            case "sticker":
                return administratorHeaderService.findStickerAll();
            default:
                return administratorHeaderService.findNoticeAll();
        }
    }

    @PatchMapping("/v1/admin/header/notice/{type}")
    public void modifyReadStatusByIds(@PathVariable("type") String type,
                                      @RequestBody List<Integer> idList){
        log.info("type = " + type + ", idList = " + idList);
        switch (type){
            case "post":
                administratorHeaderService.modifyPDeclByIds(idList);
            case "comment":
                administratorHeaderService.modifyCDeclByIds(idList);
            case "feed":
                administratorHeaderService.modifyFDeclByIds(idList);
            default:
                administratorHeaderService.modifyStickerByIds(idList);
        }
    }

    @PatchMapping("/v1/admin/sticker")
    public void modifyStickerCheckById(@RequestBody List<Integer> idList){
        log.info("idList = " + idList);

        administratorFollowService.modifyUserStickerCheck(idList);
    }

    @DeleteMapping("/v1/admin/post")
    public void deletePostDecl(String postType, Long postId){
        log.info("postType = " + postType + ", postId = " + postId);
        administratorDeclService.deletePostDecl(postId, postType);
    }
    @DeleteMapping("/v1/admin/comment")
    public void deleteCommentDecl(String commentType, Long commentId){
        log.info("commentType = " + commentType + ", commentId = " + commentId);
        administratorDeclService.deleteCommentDecl(commentId, commentType);
    }
}
