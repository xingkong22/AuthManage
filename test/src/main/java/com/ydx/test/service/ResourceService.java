package com.ydx.test.service;

import com.ydx.test.dao.ResourceDao;
import com.ydx.test.pojo.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {
    @javax.annotation.Resource
    private ResourceDao dao;

    public List<Resource> showAllReource(String id) {
        return dao.showAllReource(id);
    }

    public List<Resource> showAllReource2() {
        return dao.showAllReource2();
    }

    public List<Resource> findAllResForFP() {
        return dao.findAllResForFP();
    }
    public void deleteResource(int id) {
        dao.deleteResource(id);
    }
    public List<Resource> showAllResource3() {
        return dao.showAllResource3();
    }
    public void saveReource(Resource r) {
        dao.saveReource(r);
    }
    public void updateReource(Resource r) {
        dao.updateReource(r);
    }
}
