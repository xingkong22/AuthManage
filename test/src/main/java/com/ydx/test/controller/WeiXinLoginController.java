package com.ydx.test.controller;

import com.ydx.test.common.SecurityUtil;
import com.ydx.test.pojo.Users;
import com.ydx.test.service.WeiXinLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
public class WeiXinLoginController {
    @Autowired
    private WeiXinLoginService service;
    @RequestMapping("login2")
    public String login(Users user) {

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        Users a = service.login(user);

        if (a != null) {
            return "连接成功";
        }
        return "连接失败";
    }
}
