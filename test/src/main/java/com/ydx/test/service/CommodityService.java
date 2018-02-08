package com.ydx.test.service;

import com.ydx.test.common.FirstUtil;
import com.ydx.test.common.ThreadPool;
import com.ydx.test.dao.CommodityDao;
import com.ydx.test.dao.ImagesDao;
import com.ydx.test.pojo.Commodity;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommodityService {
    @Resource
    private CommodityDao dao;
    @Autowired
    private FreeMarkerConfig freeMarkerConfig;
    @Resource
    private ImagesDao idao;

    @Transactional
    public void addCommodity(MultipartFile file, Map<String,String> args) {
        System.out.println("sku" + args.get("sku"));

        for (String map:args.values()) {
            System.out.println(map);
        }
        System.out.println(file.getOriginalFilename());
        System.out.println("开始" + System.currentTimeMillis());

        //从线程池中拿出一个线程执行
        ThreadPool.pool.execute(new Runnable() {
            @Override
            public void run() {
                File file1 = new File("C:/bb/" + file.getOriginalFilename());

                try {
                    FileOutputStream out = new FileOutputStream(file1);

                    //存储
                    file.transferTo(file1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        if (args.get("ids").equals("0")) {

            Map<String,String> mmm = new HashMap<>();
            mmm.put("ImageName",file.getOriginalFilename());
            System.out.println("ImageName:" + file.getOriginalFilename());
            mmm.put("owner",args.get("sku"));
            System.out.println("owner:" + args.get("sku"));
            idao.updateImage(mmm);
            dao.updateCommodity(args);


        } else {
            System.out.println("结束" + System.currentTimeMillis());
            String id = FirstUtil.createId();
            args.put("sku",id);

            String id2 = FirstUtil.createId();
            Map<String,String> map = new HashMap<>();
            map.put("id",id2);
            map.put("name",file.getOriginalFilename());
            map.put("owner",id);

            dao.saveCommodity(args);
            idao.saveImages(map);
        }

    }

    public List<Commodity> showAllCommodity() {
        return dao.showAllCommodity();
    }

    public void findCommodityBySku(String sku) {
        Commodity c = dao.findCommodityBySku(sku);
        try {
            Template template = freeMarkerConfig.getConfiguration().getTemplate("item.ftl");
            String htmlName = "C:/bb/" + sku + ".html";
            FileWriter out = new FileWriter(htmlName);
            template.process(c,out);
//            template.dump(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Transactional
    public void deleteCommodity(ArrayList<String> arr) {
        dao.deleteCommodity(arr);
        idao.deleteImages(arr);

    }
}
