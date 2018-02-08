package com.ydx.test.service;

import com.ydx.test.dao.OrdersDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OrdersService {
    @Resource
    private OrdersDao dao;
    public List<Map> selectTotal() {
        return dao.selectTotal();
    }
}
