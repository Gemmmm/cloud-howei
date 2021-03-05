package com.howei.controller;

import com.howei.model.CommonResult;
import com.howei.util.JWTUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

/**
 * @author jayun
 */
@RestController
@Api(tags = "登录接口")
public class LoginController {

    @GetMapping("/login")
    public CommonResult login(@RequestParam String username, @RequestParam String password) {
        String str="admin";
        if (str.equals(username) && str.equals(password)) {
            //查询出用户权限
            String roles = "admin,query";
            //生成token
            String token = JWTUtil.generateToken(username, roles);

            return new CommonResult(0, "success", token);
        } else {
            return new CommonResult(1001, "username or password error");
        }
    }

    @GetMapping("/refreshToken")
    public CommonResult refreshToken(@RequestParam String refreshToken) {
        return new CommonResult(0, "success", refreshToken);
    }

    @GetMapping("/")
    public String index() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "now_time: " + sdf.format(System.currentTimeMillis());
    }
}