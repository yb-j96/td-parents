package com.syh.oauth.granter;

import com.syh.oauth.service.SMSUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.Map;

/**
 * @Author jyb
 * @Date 2020/4/13 15:16
 * 自定义短信授权模式
 */
public class SMSCodeLoginTokenGranter extends SMSCodeTokenGranter {
    // 自定义授权模式
    private static final String GRANTER_TYPE_SMS = "sms";
    protected SMSUserDetailsService smsUserDetailsService;

    public SMSCodeLoginTokenGranter(AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService,
                                    OAuth2RequestFactory requestFactory,SMSUserDetailsService smsUserDetailsService) {
        super(tokenServices, clientDetailsService, requestFactory, GRANTER_TYPE_SMS);
        this.smsUserDetailsService = smsUserDetailsService;
    }

    /**
     * 用户信息验证
     * @param parameters 请求参数
     * @return
     */
    @Override
    protected User getUser(Map<String, String> parameters) {
        String username = parameters.get("username");
        String smscode = parameters.get("smscode");
        return smsUserDetailsService.loadUserByMobileAndSmscode(username,smscode);
    }
}
