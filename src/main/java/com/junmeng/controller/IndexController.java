package com.junmeng.controller;

import com.junmeng.AsyncDemo;
import com.junmeng.utils.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 *
 * Created by HWJ on 2017/1/16.
 */
@RestController
public class IndexController {

    @Autowired
    AsyncDemo asyncDemo;


    @GetMapping(value = "/index")
    public ModelAndView gotoIndex(ModelMap model) throws Exception {
        asyncDemo.doTaskOne();
        asyncDemo.doTaskTwo();
        asyncDemo.doTaskThree();
       // model.addAttribute("name", "Thymeleaf");
        model.addAttribute("name", new PropertiesUtil().getProperty("custom"));
        return new ModelAndView("page/index");
    }

    @GetMapping(value = "/welcome")
    public ModelAndView gotoWelcome(ModelMap model) {
        model.put("time", new Date());
        model.put("message", "Welcome 欢迎 FreeMarker");
        return new ModelAndView("page/welcome");
    }

}
