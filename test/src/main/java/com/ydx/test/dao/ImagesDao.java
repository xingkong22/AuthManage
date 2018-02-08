package com.ydx.test.dao;

import com.ydx.test.pojo.Commodity;
import com.ydx.test.pojo.images;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;

@Repository
@Mapper
public interface ImagesDao {
    void saveImages(Map<String,String> map);
    void deleteImages(ArrayList<String> arr);
    void updateImage(Map<String,String> map);
}
