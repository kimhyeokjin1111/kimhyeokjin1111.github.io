package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultUserAdminDto;
import com.example.hippobookproject.dto.administrator.SelectUserAdminDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface AdiministratorUserMapper {
    List<ResultUserAdminDto> selectUserAdmin(@Param("selectUser") SelectUserAdminDto selectUserAdminDto,
                                             @Param("criteria") AdminUserCriteria adminUserCriteria);

    int selectAdminUserTotal(@Param("selectUser") SelectUserAdminDto selectUserAdminDto);

    void deleteUserAdminById(List<Integer> userIdList);

}
