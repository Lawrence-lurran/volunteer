package com.lurran.test;

import com.lurran.util.JDBCUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/18 7:33 下午
 */
public class Test {
    public static void main(String[] args) {
        Properties properties=new Properties();
        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
