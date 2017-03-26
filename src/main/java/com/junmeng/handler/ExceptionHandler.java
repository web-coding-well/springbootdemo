package com.junmeng.handler;

import com.junmeng.bean.Result;
import com.junmeng.exception.CommonException;
import com.junmeng.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 异常处理器，使得异常发生时返回给客户端的结果仍能按照要求
 * Created by HWJ on 2017/3/19.
 */
@ControllerAdvice
public class ExceptionHandler {
    public  final Logger logger= LoggerFactory.getLogger(this.getClass());
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        e.printStackTrace();
        if(e instanceof CommonException){
            CommonException ce=(CommonException)e;
            return ResultUtil.error(ce.errorCode,ce.getMessage());
        }
        logger.error("系统异常:"+e.getClass());

        return ResultUtil.error(-1,"未知错误",e.getClass());
    }

}
