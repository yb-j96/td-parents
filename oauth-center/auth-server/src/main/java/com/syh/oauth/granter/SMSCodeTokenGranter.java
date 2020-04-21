package com.syh.oauth.granter;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.Map;

/**
 * @Author jyb
 * @Date 2020/4/13 15:11
 * 自定义新增短信授权模式
 */
public abstract class SMSCodeTokenGranter extends AbstractTokenGranter {

    protected SMSCodeTokenGranter(AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory, String grantType) {
        super(tokenServices, clientDetailsService, requestFactory, grantType);
    }

    /**
     * 重写方法
     * @param client
     * @param tokenRequest
     * @return
     */
    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> parameters = tokenRequest.getRequestParameters();
        User user = getUser(parameters);
        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(client);
        PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(user, null, user.getAuthorities());
        authentication.setDetails(user);
        return new OAuth2Authentication(oAuth2Request,authentication);
    }

    // 自定义用户细节服务实现
    protected abstract User getUser(Map<String, String> parameters);
}
