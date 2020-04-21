package com.syh.user.mapper;

import com.syh.common.model.SysRole;
import com.syh.common.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @Author jyb
 * @Date 2020/4/15 10:49
 */
@Mapper
public interface UserMapper {
    @Select("select u.* from sys_user u   where u.username = #{username}")
    SysUser selectUserByUserName(String username);

     @Select("select r.* from sys_role_user ru inner join sys_role r on r.id = ru.roleId where ru.userId = #{userId}")
     Set<SysRole> findRolesByUserId(Long userId);
}
