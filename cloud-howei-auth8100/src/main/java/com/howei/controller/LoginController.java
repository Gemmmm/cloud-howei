package com.howei.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "登录管理")
@RequestMapping("/auth")
public class LoginController {

    @GetMapping("get")
    public String get() {
        return "11111";
    }
}
