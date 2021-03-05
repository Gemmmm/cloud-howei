package com.howei.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wa")
@Api(tags = "测试")
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
