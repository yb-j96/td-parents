package com.syh.oauth.service;

import com.syh.common.model.LoginAppUser;
import com.syh.common.model.LoginUser;
import com.syh.oauth.feign.TdClientFeign;
import com.syh.oauth.feign.UserClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author jyb
 * @Date 2020/4/14 15:44
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private HttpSession session;
    @Autowired
    private TdClientFeign tdClientFeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            session.setAttribute("user",username);
            return new User(username,"$2a$10$MZ9fzn/Ny2CXl39OnIEbAudHdmrL4WuzMvqH9RIFxAajMSiNNSSLi",authorities);
        }else if ("jyb".equals(username)){
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            session.setAttribute("user",username);
            return new User(username,"$2a$10$MZ9fzn/Ny2CXl39OnIEbAudHdmrL4WuzMvqH9RIFxAajMSiNNSSLi",authorities);
        }else {
            throw new UsernameNotFoundException("用户不存在！");
        }*/
        LoginUser loginUser = tdClientFeign.selectLoginUser(username);
        if (loginUser != null) {
            session.setAttribute("user",loginUser);
            return loginUser;
        }
        throw new UsernameNotFoundException("用户不存在！！");
    }
}
