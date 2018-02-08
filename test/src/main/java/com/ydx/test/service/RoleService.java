package com.ydx.test.service;

import com.ydx.test.common.FirstUtil;
import com.ydx.test.dao.RoleDao;
import com.ydx.test.pojo.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    @Resource
    private RoleDao dao;

    public List<Role> showAllRole(Map<String,Integer> map) {
        return dao.showAllRole(map);
    }

    public List<Role> showAllRoles() {
        return dao.showAllRoles();
    }

    public void deleteRole(ArrayList<String> rid) {
        dao.deleteRole(rid);
    }
    public void saveRole(Role role) {
        String uid = FirstUtil.createId();
        role.setId(uid);
        dao.saveRole(role);
    }
    public void updateRole(Role role) {
        dao.updateRole(role);
    }

    @Transactional
    public void doFP(Map<String, Object> data) {

        String roleid = (String)data.get("roleid");
        Map<String,String> map = new HashMap<>();
        map.put("roleid",roleid);
        dao.deleteByRoleid(map);
        dao.doFP(data);
    }
}
