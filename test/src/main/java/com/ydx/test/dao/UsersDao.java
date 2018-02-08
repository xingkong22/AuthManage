package com.ydx.test.dao;

import com.ydx.test.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UsersDao {
    public List<Users> showAllUsers(Map<String, Integer> map);
    public int selectCount();
    public List<Users> searchUser(Map<String, String> map);
    public void deleteUserById(String id);
    public void deleteUserById2(ArrayList<String> idd);
    public void saveUser(Users user);
    public void updateUser(Users user);
    public void saveUserRole(Users user);
    Users login(Users user);
    public void updateUserRole(Users user);

    public List<Users> searchUser2(Map<String, String> map);
}
