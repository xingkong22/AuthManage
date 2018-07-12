package com.ydx.test.common;

import java.util.UUID;

public class FirstUtil {
    public static String createId() {
    	//12121212
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
