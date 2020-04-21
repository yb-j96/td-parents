package com.syh.oauth.feign;

import com.syh.common.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author jyb
 * @Date 2020/4/16 10:15
 */
@FeignClient(value = "td-server",configuration = FeignConfig.class)
public interface TdClientFeign {
    @GetMapping(value = "/T3/UserController/selectLoginUser",params = "username")
    LoginUser selectLoginUser(@RequestParam("username")String username);
}
