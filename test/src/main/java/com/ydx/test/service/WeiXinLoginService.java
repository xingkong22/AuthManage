package com.ydx.test.service;

import com.ydx.test.common.SecurityUtil;
import com.ydx.test.dao.WeiXinLoginDao;
import com.ydx.test.pojo.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WeiXinLoginService {
    @Resource
    private WeiXinLoginDao dao;

    public Users login(Users user) {
       String password = SecurityUtil.md5(user.getPassword());
       user.setPassword(password);
        return dao.login2(user);
    }
}
