package com.howei.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试")
public class TestController {

    @Authorization(value = "howei_auth",scopes = {
            @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
    })
    @GetMapping("/test")
    public String test(){
        return "test;;";
    }
}
