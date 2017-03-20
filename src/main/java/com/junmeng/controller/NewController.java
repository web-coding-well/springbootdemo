package com.junmeng.controller;

import com.junmeng.bean.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by HWJ on 2017/3/18.
 */
@RestController//spring4新加注解
@RequestMapping(value = "/main")
public class NewController {

    //从配置文件中装配某个对象
    @Autowired
    private Girl girl;

    //从配置文件中读取某个属性
    @Value("${Girl.age}")
    private Integer age;

    //rest风格
    //如要测试post方式，按下ctrl+shift+a,输入rest client,即可进行测试
    //不指定method的话get和post都可以，但还是推荐根据使用场景指定get或post
    @RequestMapping(value = {"/new/{id}","/hello/{id}"},method = {RequestMethod.GET ,RequestMethod.POST})
    public String sayHello(@PathVariable("id") Integer id){
        StringBuilder builder=new StringBuilder();
        builder.append("hello spring boot~").append("</br>")
        .append("name=").append(girl.getName())
        .append(" age=").append(age).append("</br>")
        .append("id=").append(id);
        return builder.toString();
    }

    //传统风格
    //http://localhost:8084/junmeng/main/new2?id=3
   // @RequestMapping(value = {"/new2"},method = RequestMethod.GET)
    @GetMapping(value = ("/new2"))
    public String sayHello2(@RequestParam(value = "id",required = false,defaultValue = "-1") Integer id){
        StringBuilder builder=new StringBuilder();
        builder.append("hello spring boot~").append("</br>")
                .append("name=").append(girl.getName())
                .append(" age=").append(age).append("</br>")
                .append("id=").append(id);
        return builder.toString();
    }

    @GetMapping(value = "/index")
    public String gotoIndex(ModelMap model) {
         return "page/index";
    }

}
