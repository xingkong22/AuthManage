package com.ydx.test.dao;

import com.ydx.test.pojo.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ResourceDao {

    List<Resource> showAllReource(String id);
    List<Resource> showAllReource2();

    List<Resource> findAllResForFP();
    void deleteResource(int id);
    List<Resource> showAllResource3();
    void saveReource(Resource r);
    void updateReource(Resource r);
}
