package com.example.hippobookproject.api.board;

import com.example.hippobookproject.dto.board.PostSearchOptDto;
import com.example.hippobookproject.dto.board.PostSearchResultDto;
import com.example.hippobookproject.dto.declaration.WriteDeclDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.dto.page.AdminUserPage;
import com.example.hippobookproject.service.board.BoardMainService;
import com.example.hippobookproject.service.declaration.DeclarationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardApi {
    private final BoardMainService boardMainService;
    private final DeclarationService declarationService;

    @GetMapping("/v1/board/{type}/posts")
    public Map<String,Object> findPostBytype(PostSearchOptDto postSearchOptDto,
                                                    AdminUserCriteria criteria,
                                                    @PathVariable("type") String postType){
        log.info("postSearchOptDto = " + postSearchOptDto + ", criteria = " + criteria + ", postType = " + postType);
        List<PostSearchResultDto> post = boardMainService.findPost(postSearchOptDto, criteria, postType);
        int postTotal = boardMainService.findPostTotal(postSearchOptDto, postType);
        AdminUserPage postPage = new AdminUserPage(criteria, postTotal);

        Map<String,Object> postInfoMap = new HashMap<>();
        postInfoMap.put("post", post);
        postInfoMap.put("postPage", postPage);

        return postInfoMap;
    }

    @PostMapping("/v1/{declType}/decl")
    public void registerDeclByType(@PathVariable("declType") String declType,
                                   @RequestBody WriteDeclDto writeDeclDto){
        log.info("declType = " + declType + ", writeDeclDto = " + writeDeclDto);
        declarationService.registerDecl(declType, writeDeclDto);
    }

}
