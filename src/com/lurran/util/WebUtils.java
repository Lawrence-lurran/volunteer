package com.lurran.util;

import org.apache.commons.beanutils.BeanUtils;
import java.util.Map;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/5/21 3:22 下午
 */
public class WebUtils {
    /**
     * 把map中的值注入到javabean中
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换为int类型
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue ){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            // e.printStackTrace();
        }
        return defaultValue;
    }
}
