package com.ydx.test.controller;

import com.ydx.test.pojo.Resource;
import com.ydx.test.pojo.Users;
import com.ydx.test.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ResourceController {
    @Autowired
    private ResourceService service;

    @RequestMapping("showAllReource")
    public List<Resource> showAllReource(HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        System.out.println(user.getId());
        String id = user.getId();
        return service.showAllReource(id);
    }
    @RequestMapping("findAllResForFP")
    public List<Resource> findAllResForFP() {
        return service.findAllResForFP();
    }
    @RequestMapping("showAllReource2")
    public List<Resource> showAllReource2() {
        return service.showAllReource2();
    }
    @RequestMapping("deleteResource")
    public String deleteResource(@RequestBody int id) {
        service.deleteResource(id);
        return "1";
    }
    @RequestMapping("showAllResource3")
    public List<Resource> showAllResource3() {
        return service.showAllResource3();
    }
    @RequestMapping("saveReource")
    public String saveReource(Resource r,String ids) {
        System.out.println("---------" + r);
        if (ids.equals("0")) {
            service.saveReource(r);
            return "1";
        } else {
            service.updateReource(r);
        }
        return null;
    }

}
