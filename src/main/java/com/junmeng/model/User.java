package com.junmeng.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by HWJ on 2017/3/18.
 */
@Entity
@Table(name="tb_user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    //注意此用法仍然不能解决空字符串的问题
    @NotNull(message = "名字不能为空")
    private String name;

    @Min(value = 18,message = "还未成年")
    private int age;
    private int sex;

    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
