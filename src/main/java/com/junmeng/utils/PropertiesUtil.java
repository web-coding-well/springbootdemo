package com.junmeng.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

/**
 * 适合自定义的配置信息，spring 容器默认的配置信息会读不到
 * 而且不能有层级
 * 比如 Girl.name就获取不到
 * 而且如果是外部配置文件的话这个类就相当于失效了
 * Created by HWJ on 2017/3/26.
 */
@Component
public class PropertiesUtil {

    private static Properties props;

    static {
        try {
            Resource resource = new ClassPathResource("/application.yml");//
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取属性
     *
     * @param key
     * @return
     */
    public static String getProperty(String key) {

        return props == null ? null : props.getProperty(key);

    }

    /**
     * 获取属性
     *
     * @param key          属性key
     * @param defaultValue 属性value
     * @return
     */
    public static String getProperty(String key, String defaultValue) {

        return props == null ? null : props.getProperty(key, defaultValue);

    }

    /**
     * 获取properyies属性
     *
     * @return
     */
    public static Properties getProperties() {
        return props;
    }

}



