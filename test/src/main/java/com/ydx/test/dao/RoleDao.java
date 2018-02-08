package com.ydx.test.dao;

import com.ydx.test.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface RoleDao {
    List<Role> showAllRole(Map<String, Integer> map);
    List<Role> showAllRoles();
    public void deleteRole(ArrayList<String> rid);
    void saveRole(Role role);
    void updateRole(Role role);

    void doFP(Map<String, Object> data);
    void deleteByRoleid(Map<String, String> map);
}
