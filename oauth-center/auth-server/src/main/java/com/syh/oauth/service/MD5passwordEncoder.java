package com.syh.oauth.service;

import com.syh.common.util.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author jyb
 * @Date 2020/4/15 17:56
 */
public class MD5passwordEncoder implements PasswordEncoder {
    private String SALTSTR = "2c2ec7ecd7bf44e58a8af4a354902da9";

    @Override
    public String encode(CharSequence rawPassword) {
        try {
            // TODO 查询用户存储的加密盐值
            String encryptedPwd = MD5.getEncryptedPwd(rawPassword.toString(), SALTSTR);
            return encryptedPwd;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        try {
            // TODO 查询用户存储的加密盐值
            if (MD5.validPassword(rawPassword.toString(), encodedPassword, SALTSTR))
                return true;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
