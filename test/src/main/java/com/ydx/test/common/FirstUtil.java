package com.ydx.test.common;

import java.util.UUID;

public class FirstUtil {
    public static String createId() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
