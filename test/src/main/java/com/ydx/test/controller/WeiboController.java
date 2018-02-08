package com.ydx.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

import javax.servlet.http.HttpSession;


@Controller
public class WeiboController {

    @RequestMapping("toWeiboLogin")
    public String toLogin() {
        String path = "";
        Oauth auth = new Oauth();
        try {
            path = auth.authorize("code",null);
        } catch (WeiboException e) {
            e.printStackTrace();
        }
        return "redirect:" + path;
    }


    @RequestMapping("weiboback")
    public String weiboBack(String code, HttpSession session) {
        Oauth auth = new Oauth();
        AccessToken token = null;

        try {
            token = auth.getAccessTokenByCode(code);
            String s = token.getAccessToken();
            session.setAttribute("token",s);
            Users us = new Users(s);

            String uid = token.getUid();
            System.out.println(uid);
            User user = us.showUserById(uid);
            System.out.println("用户:" + user.getName());
        } catch (WeiboException e) {
            e.printStackTrace();
        }
        return "main.html";
    }

}
