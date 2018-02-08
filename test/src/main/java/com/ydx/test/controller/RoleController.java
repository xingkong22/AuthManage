package com.ydx.test.controller;

import com.ydx.test.pojo.Role;
import com.ydx.test.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {
    @Autowired
    private RoleService service;
    @RequestMapping("showAllRole")
    public List<Role> showAllRole(Integer page, Integer size) {
        int start = (page - 1) * size;
        Map<String,Integer> map = new HashMap<>();
        map.put("start",start);
        map.put("size",size);
        return service.showAllRole(map);
    }

    @RequestMapping("doFP")
    public String doFP(@RequestBody ArrayList<String> args) {
        String roleid = args.get(0);
        args.remove(0);
        Map<String,Object> data = new HashMap<>();
        data.put("roleid",roleid);
        data.put("ids",args);
        service.doFP(data);
        return "1";


    }

    @RequestMapping("showAllRoles")
    public List<Role> showAllRoles() {
        return service.showAllRoles();
    }
    @RequestMapping("deleteRole")
    public String deleteRole(@RequestBody ArrayList<String> rid) {
        System.out.println(rid.size());
        service.deleteRole(rid);
        return "1";
    }
    @RequestMapping("saveRole")
    public String saveRole(Role role) {
        if (!role.getId().equals("0")) {
            service.updateRole(role);
        }else {
            service.saveRole(role);
        }
        return "1";
    }
}
