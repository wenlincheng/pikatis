package com.pikaman.io;

import java.io.InputStream;

/**
 * 读取配置文件
 * @author : Pikaman
 * @version : 1.0.0
 * @date : 2020/9/10 8:19 下午
 */
public class Resources {

    public static InputStream getResourceAsStream(String path) {
        InputStream inputStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return inputStream;
    }
}
