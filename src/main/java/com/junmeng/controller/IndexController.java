package com.junmeng.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by HWJ on 2017/1/16.
 */
@RestController
public class IndexController {

    @GetMapping(value = "/index")
    public ModelAndView gotoIndex(ModelMap model) {
        return new ModelAndView("page/index");
    }

}
