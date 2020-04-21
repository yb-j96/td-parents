package com.syh.user.service.impl;

import com.syh.common.model.LoginAppUser;
import com.syh.common.model.SysRole;
import com.syh.common.model.SysUser;
import com.syh.user.mapper.UserMapper;
import com.syh.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author jyb
 * @Date 2020/4/15 10:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginAppUser selectUserByUserName(String username) {
       /* SysUser sysUser = userMapper.selectUserByUserName(username);
        if (sysUser != null) {
            LoginAppUser loginAppUser = new LoginAppUser();
            BeanUtils.copyProperties(sysUser, loginAppUser);
            Set<SysRole> rolesByUserId = userMapper.findRolesByUserId(sysUser.getId());
            loginAppUser.setSysRoles(rolesByUserId);
            return loginAppUser;
        }*/
        return null;
    }
}
