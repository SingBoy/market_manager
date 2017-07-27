package com.sigal.common.utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * 属性文件 读取 
 * @author yuxiangjie
 */

public class PropertiesUtil {

    private static PropertiesUtil propertiesUtil;
    private static Properties dbProps;

    /**
     * 读取配置文件的属性并完成初始化
     */
    private PropertiesUtil() {
        try {
            InputStream is = getClass().getResourceAsStream("/config.properties");
            dbProps = new Properties();
            dbProps.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得单例
     * @return
     */
    public static PropertiesUtil getInstance(){
        if(propertiesUtil == null){
            propertiesUtil = new PropertiesUtil();

        }
        return propertiesUtil;
    }

    /**
     * 根据配置文件中的key获取value值
     * @param key
     * @return
     */
    public String getvalue(String key){
        return dbProps.getProperty(key);

    }
}
