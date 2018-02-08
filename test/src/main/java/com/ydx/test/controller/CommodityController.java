package com.ydx.test.controller;

import com.ydx.test.pojo.Commodity;
import com.ydx.test.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("commodity")
public class CommodityController {
    @Autowired
    private CommodityService service;

    @RequestMapping("addCommodity")
    public String addCommodity(@RequestParam("f1")MultipartFile file, @RequestParam Map<String,String> args) {
        service.addCommodity(file,args);
        return "1";
    }
    @RequestMapping("showAllCommodity")
    public List<Commodity> showAllCommodity() {
        return service.showAllCommodity();
    }

    //上架,使用restful风格的url
    @RequestMapping(value = "shangJiaCommodity/{sku}",method = RequestMethod.GET)
    public String shangJiaCommodity(@PathVariable String sku) {
        service.findCommodityBySku(sku);
        return "1";

    }
    @RequestMapping("delete")
    public void deleteCommodity(@RequestBody ArrayList<String> x) {
        System.out.println(x);
        service.deleteCommodity(x);

    }
}
