package com.ydx.test.controller;

import com.ydx.test.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService service;
    @RequestMapping("selectTotal")
    public List<Map> selectTotal() {
        return service.selectTotal();
    }
}
