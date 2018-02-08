package com.ydx.test.controller;

import com.aliyuncs.exceptions.ClientException;
import com.ydx.test.common.SMSUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
//@RequestMapping("sms")
//@RestController
public class CodeController {
    @RequestMapping("createCode/{phone}")
    public String createCode(@PathVariable String phone, HttpSession session) {
        try {
            String code = SMSUtils.sendSms(phone);
            session.setAttribute("vcode", code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "1";
    }
}
