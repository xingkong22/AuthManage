package com.ydx.test.service;

import com.ydx.test.common.FirstUtil;
import com.ydx.test.common.SecurityUtil;
import com.ydx.test.dao.UsersDao;
import com.ydx.test.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UsersDao dao;

    public List<Users> showAllUsers(Map<String,Integer> map) {
        return dao.showAllUsers(map);
    }

    public int selectCount() {
        return dao.selectCount();
    }

    public List<Users> searchUser(Map<String,String> map) {
        return dao.searchUser(map);
    }

    public void deleteUserById(String id) {
        dao.deleteUserById(id);

    }

    public void deleteUser(ArrayList<String> idd) {
        dao.deleteUserById2(idd);
    }
    @Transactional
    public void saveUser(Users user) {
        String uid = FirstUtil.createId();
        user.setId(uid);
        //加密  密码
        String password = SecurityUtil.md5(user.getPassword());
        user.setPassword(password);
        dao.saveUser(user);
        dao.saveUserRole(user);
    }
    @Transactional
    public void updateUser(Users user) {
        String id = user.getId();
        String rrid = user.getRrid();
        user.setId(id);
        user.setRrid(rrid);
        dao.updateUser(user);
        dao.updateUserRole(user);
    }
    public Users login(Users user) {
        String password = SecurityUtil.md5(user.getPassword());
        user.setPassword(password);
        return dao.login(user);
    }


    public List<Users> searchUser2(Map<String, String> map) {
        return dao.searchUser2(map);
    }
}
