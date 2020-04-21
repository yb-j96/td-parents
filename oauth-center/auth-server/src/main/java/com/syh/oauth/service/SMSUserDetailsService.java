package com.syh.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jyb
 * @Date 2020/4/13 15:22
 * 自定短信授权模式的UserDetailsService
 */
@Service
public class SMSUserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 检验用户名及验证码
     *
     * @param mobile
     * @param smscode
     * @return
     */
    public User loadUserByMobileAndSmscode(String mobile, String smscode) {
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(smscode)) {
            throw new InvalidGrantException("您输入的手机号或短信验证码不正确");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        return new User(mobile, passwordEncoder.encode("12346"), authorities);
    }
}
