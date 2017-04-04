package com.junmeng.controller;

import com.junmeng.bean.Girl;
import com.junmeng.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Redis例子
 * Created by HWJ on 2017/4/3.
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisController {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    RedisService redisService;

    @GetMapping("/get")
    public Object get(@RequestParam(value = "key",required = false,defaultValue = "") String key){
        logger.info("key={},value={}",key,redisService.get(key));
        return redisService.get(key);
    }

    @GetMapping("/set")
    public String get(@RequestParam(value = "key",required = true,defaultValue = "") String key,
                      @RequestParam(value = "value",required = true,defaultValue = "") String value){
         redisService.set(key,value,5000);
         return "success";
    }

    @GetMapping("/setGirl")
    public String setGirl(Girl girl){
        logger.info("girl={}",girl.toString());
         redisService.setGirl(girl.getName(),girl);
        return "success";
    }

    @GetMapping("/getGirl")
    public Girl getGirl(@RequestParam(value = "name",required = true,defaultValue = "") String name){
        return redisService.getGirl(name);
    }

}
