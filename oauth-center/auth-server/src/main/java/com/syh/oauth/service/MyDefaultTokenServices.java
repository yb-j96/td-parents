package com.syh.oauth.service;

import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Service;

/**
 * @Author jyb
 * @Date 2020/4/15 10:37
 */
public class MyDefaultTokenServices extends DefaultTokenServices {
    public MyDefaultTokenServices() {
        super();
    }

    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 30; // default 30 days.

    private int accessTokenValiditySeconds = 20; // default 12 hours.

    @Override
    public void setRefreshTokenValiditySeconds(int refreshTokenValiditySeconds) {
        super.setRefreshTokenValiditySeconds(refreshTokenValiditySeconds);
    }

    @Override
    public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
        super.setAccessTokenValiditySeconds(accessTokenValiditySeconds);
    }
}
