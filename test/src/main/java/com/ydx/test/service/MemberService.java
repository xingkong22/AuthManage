package com.ydx.test.service;

import com.ydx.test.dao.MemberDao;
import com.ydx.test.pojo.Member;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {
    @Resource
    private MemberDao dao;
    @Resource
    private JmsTemplate jmsTemplate;

    public void selectId() {


        List<String> list = new ArrayList<>();

        List<Map> map = dao.selectId();
        LocalDate now = LocalDate.now();
        MonthDay day = MonthDay.from(now);
        System.out.println(day);

        for (int i = 0; i < map.size(); i++) {
            String id = (String) map.get(i).get("id");
            String tel = (String) map.get(i).get("tel");
            //System.out.println(id);
            //System.out.println(tel);
            String a = id.substring(10,12);
            String b = id.substring(12,14);
            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);
            System.out.println(c);
            System.out.println(d);
            //System.out.println(a);

            MonthDay of = MonthDay.of(c, d);

            if (day.equals(of)) {
                System.out.println("id:" + id);
                System.out.println("tel:" + tel);

                list.add(tel);
            }
        }

        jmsTemplate.convertAndSend("second2",list);
    }
}
