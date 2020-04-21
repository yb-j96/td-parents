package com.syh.user.service;

import com.syh.common.model.LoginAppUser;
import com.syh.common.model.SysUser;

/**
 * @Author jyb
 * @Date 2020/4/15 10:56
 */
public interface UserService {
    LoginAppUser selectUserByUserName(String username);
}
