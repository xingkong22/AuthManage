package com.ydx.test.controller;

import com.ydx.test.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("member")
public class MemberController {
    @Autowired
    private MemberService service;
    @RequestMapping("selectId")
    public void selectId() {

        service.selectId();
    }

    @JmsListener(destination = "second2")
    public void receive(List<String> list) {
        System.out.println("收到" +list);
    }
}
