package com.ydx.test.common;

import java.util.UUID;

public class FirstUtil {
    public static String createId() {
    	//12121212
    	//今天是2018年7月12日
    	//asdasdasd
    	//dfgdfhfghgfh
    	//565656
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
