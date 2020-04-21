package com.syh.oauth.feign;

import com.syh.common.model.LoginAppUser;
import com.syh.common.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author jyb
 * @Date 2020/4/14 17:27
 */
@FeignClient(value = "user-center",configuration = FeignConfig.class)
public interface UserClientFeign {

    @GetMapping(value = "/user/selectLoginUser",params = "username")
    LoginUser selectUserByUserName(@RequestParam("username")String username);

}
