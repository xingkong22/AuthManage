package com.ydx.test.controller;

import com.ydx.test.common.SecurityUtil;
import com.ydx.test.pojo.Users;
import com.ydx.test.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Resource
    private UserService service;
    @RequestMapping("login")
    public String login(Users user, HttpSession session) {

//        String vcode = session.getAttribute("vcode").toString();
//        if (!user.getVcode().equals(vcode)) {
//            return "-1";
//        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), SecurityUtil.md5(user.getPassword()));
        subject.login(token);

        Users u = service.login(user);

        if (u != null) {
            session.setAttribute("user",u);
            //System.out.println(u.getId());
            return "1";
        }
        return "-1";
    }
    @RequestMapping("showallusers")
    public List<Users> showAllUsers(Integer page,Integer size) {
        int start = (page - 1) * size;
        Map<String,Integer> map = new HashMap<>();
        map.put("start",start);
        map.put("size",size);
        return service.showAllUsers(map);
    }
    @RequestMapping("selectCount")
    public int selectCount() {
        System.out.println("count"+service.selectCount());
        return service.selectCount();
    }
    @RequestMapping("searchUser")
    public List<Users> searchUser(String key, String type) {
        Map<String,String> map = new HashMap<>();
        if (type.equals("username")) {
            map.put("username",key);
            return service.searchUser(map);
        }else if (type.equals("name")) {
            map.put("name",key);
            return service.searchUser2(map);
        }
            return null;
    }
    @RequestMapping("deleteUserById")
    public String deleteUserById(String id) {
        service.deleteUserById(id);
        return "1";
    }
    @RequestMapping("deleteUserById2")
    public String deleteUsers(@RequestBody ArrayList<String> idd) {
        System.out.println(idd.size());
        service.deleteUser(idd);
        return "1";
    }
    @RequestMapping("saveUser")
    public String saveUser(Users user) {
        if (!user.getId().equals("0")) {
            System.out.println(user.getId());
            System.out.println(user.getRrid());
            service.updateUser(user);
        }else {
            //System.out.println(user.getId());
            service.saveUser(user);
        }

        return "1";
    }
}
