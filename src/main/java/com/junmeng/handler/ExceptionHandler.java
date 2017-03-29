package com.junmeng.handler;

import com.junmeng.bean.Result;
import com.junmeng.exception.BussinessException;
import com.junmeng.utils.DateUtil;
import com.junmeng.utils.LogUtil;
import com.junmeng.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 异常处理器，使得异常发生时返回给客户端的结果仍能按照要求
 * Created by HWJ on 2017/3/19.
 */
@ControllerAdvice
public class ExceptionHandler {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        e.printStackTrace();
        writeLog(e);
        if (e instanceof BussinessException) {
            BussinessException ce = (BussinessException) e;
            return ResultUtil.error(ce.errorCode, ce.getMessage());
        }
        logger.error("系统异常:" + e.getClass());
        return ResultUtil.error(-1, "未知错误", e.getClass());
    }

    /**
     * 记录异常日志
     * @param ex
     */
    public void writeLog(Exception ex) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //查找10天前的文件，如果存在则删除
        Date date=DateUtil.getDate(-10);
        File file=new File("./log/"+sdf.format(date)+".log");
        if(file.exists()){
            file.delete();
        }
        LogUtil.writeExceptionLog(ex,"./log/"+sdf.format(new Date())+".log",10*1024*1024);
    }

}
