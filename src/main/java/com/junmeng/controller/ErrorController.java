package com.junmeng.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义错误页面
 * Created by HWJ on 2017/3/30.
 */
@RestController
@RequestMapping("error")
public class ErrorController {

   @GetMapping(value = "/401")
    public ModelAndView handle401Error(ModelMap model){
        return  new ModelAndView("error/401");
    }

    @GetMapping(value = "/404")
    public ModelAndView handle404Error(ModelMap model){
        return  new ModelAndView("error/404");
    }

    @GetMapping(value = "/500")
    public ModelAndView handle500Error(ModelMap model){
        return  new ModelAndView("error/500");
    }

}
