package com.junmeng.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "错误页")
public class ErrorController {

    @ApiOperation(value = "401错误页", notes = "当出现401错误时跳转到此页面")
    @GetMapping(value = "/401")
    public ModelAndView handle401Error(ModelMap model) {
        return new ModelAndView("error/401");
    }

    @ApiOperation(value = "404错误页", notes = "当出现404错误时跳转到此页面")
    @GetMapping(value = "/404")
    public ModelAndView handle404Error(ModelMap model) {
        return new ModelAndView("error/404");
    }

    @ApiOperation(value = "500错误页", notes = "当出现500错误时跳转到此页面")
    @GetMapping(value = "/500")
    public ModelAndView handle500Error(ModelMap model) {
        return new ModelAndView("error/500");
    }

}
