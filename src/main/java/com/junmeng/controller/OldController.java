package com.junmeng.controller;

import com.junmeng.bean.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by HWJ on 2017/3/18.
 */
@Controller
@ResponseBody
public class OldController {

    @Autowired
    private Girl girl;

    @Value("${Girl.age}")
    private Integer age;

    @RequestMapping(value = "/old",method = RequestMethod.GET )
    public String sayHello(){
        return "hello spring boot~"+"name="+girl.getName()+",age="+age;
    }
}
