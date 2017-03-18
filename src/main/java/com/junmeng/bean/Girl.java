package com.junmeng.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 此对象是配置文件中定义的Girl对象
 * Created by HWJ on 2017/3/18.
 */
@ConfigurationProperties(prefix = "Girl") //获取前缀是Girl的配置
@Component
public class Girl {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
