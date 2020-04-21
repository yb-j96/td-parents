package com.syh.oauth.config;

import com.syh.oauth.granter.SMSCodeLoginTokenGranter;
import com.syh.oauth.service.MyClientDetailsService;
import com.syh.oauth.service.SMSUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author jyb
 * @Date 2020/4/9 13:56
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServiceConfigurer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private SMSUserDetailsService smsUserDetailsService;
    @Autowired
    private MyClientDetailsService myClientDetailsService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients()
                .passwordEncoder(passwordEncoder)
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /*clients.inMemory()
                .withClient("client_1")
                .secret(passwordEncoder.encode("123"))
                .scopes("all")
                .authorizedGrantTypes("authorization_code","password")
                .redirectUris("https://www.baidu.com")
                .accessTokenValiditySeconds(1000*60*60*60)
                .refreshTokenValiditySeconds(1000*60*60*60)
                .and()
                .withClient("client_2")
                .secret(passwordEncoder.encode("123"))
                .scopes("all")
                .authorizedGrantTypes("sms")
                .redirectUris("https://www.baidu.com")
                .accessTokenValiditySeconds(1000*60*60*60)
                .refreshTokenValiditySeconds(1000*60*60*60);*/
        clients.withClientDetails(myClientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenGranter(tokenGranter(endpoints))
                .tokenStore(new RedisTokenStore(redisConnectionFactory));
//                .accessTokenConverter(jwtAccessTokenConverter());
    }

    private TokenGranter tokenGranter(final AuthorizationServerEndpointsConfigurer endpoints) {
        List<TokenGranter> granters = new ArrayList<TokenGranter>(Arrays.asList(endpoints.getTokenGranter()));
        granters.add(new SMSCodeLoginTokenGranter(endpoints.getTokenServices(), endpoints.getClientDetailsService(), endpoints.getOAuth2RequestFactory(),smsUserDetailsService));
        return new CompositeTokenGranter(granters);
    }

    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        return new JwtAccessTokenConverter();
    }

}
