package com.howei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/socket/{userId}")
@Controller
public class WebSocket {


    // 连接Socket触发
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session, @RequestParam(required = false) String token) throws IOException {
        System.out.println("userId::"+userId);
        System.out.println("token::"+token);

    }

    // 离线或关闭窗口、异常关闭浏览器触发
    @OnClose
    public void onClose() throws IOException {
    }

    // 服务端向客户端推送消息
    @OnMessage
    public void onMessage(String messageJson) throws IOException {
        System.out.println(messageJson);
    }


    // 异常接收
    @OnError
    public void onError(Session session, Throwable error) {

    }


}
