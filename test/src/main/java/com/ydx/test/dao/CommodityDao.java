package com.ydx.test.dao;

import com.ydx.test.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CommodityDao {
    void saveCommodity(Map<String,String> map);
    List<Commodity> showAllCommodity();

    Commodity findCommodityBySku(String sku);
    void deleteCommodity(ArrayList<String> arr);
    void updateCommodity(Map<String, String> map);
}
