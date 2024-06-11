package com.example.hippobookproject.controller.administrator;

import com.example.hippobookproject.dto.administrator.ResultChartAdminDto;
import com.example.hippobookproject.dto.administrator.ResultUserAdminDto;
import com.example.hippobookproject.dto.administrator.SelectUserAdminDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.dto.page.AdminUserPage;
import com.example.hippobookproject.service.administrator.AdministratorChartService;
import com.example.hippobookproject.service.administrator.AdministratorUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdministratorController {
    private final AdministratorUserService administratorUserService;
    private final AdministratorChartService administratorChartService;

    @GetMapping("/user")
    public String adminUser(@ModelAttribute("selectUserAdminDto") SelectUserAdminDto selectUserAdminDto, Model model,
                            AdminUserCriteria criteria){
        log.info("selectUserAdminDto = " + selectUserAdminDto + ", criteria = " + criteria);

        List<ResultUserAdminDto> userList = administratorUserService.findUserAdmin(selectUserAdminDto,
                criteria);
        int total = administratorUserService.findUserAdminTotal(selectUserAdminDto);
        AdminUserPage page = new AdminUserPage(criteria, total);
        log.info("page = " + page, "total = " + total);

//        model.addAttribute("selectUserAdminDto", selectUserAdminDto);
        model.addAttribute("userList", userList);
        model.addAttribute("page", page);

        return "administrator/admin_user";
    }

    @GetMapping("/chart")
    public String adminChart(Model model){

        List<ResultChartAdminDto> visitList = administratorChartService.findVisitByRange(0);
        log.info("visitList = {}", visitList.size());
        model.addAttribute("term", 0);
        model.addAttribute("visistList", visitList);

        return "administrator/admin_chart";
    }

    @GetMapping("/declaration")
    public String adminDeclaration(){
        return "administrator/admin_declaration";
    }

    @GetMapping("/follow")
    public String adminFollow(){
        return "administrator/admin_follow";
    }

//    @GetMapping("/header")
//    public String adminHeader() {
//        return "administrator/fragment/admin_header";
//    }

}
