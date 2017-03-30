package com.junmeng.utils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HWJ on 2017/3/29.
 */
public class LogUtil {


    /**
     * 记录异常日志
     * @param ex            异常
     * @param fullPathName  完整路径名，比如“./log/2017.log”
     * @param maxLength     文件最大空间，单位Byte，超过则重新覆盖
     */
    public static void writeExceptionLog(Exception ex, String fullPathName, int maxLength) {
        //详细错误堆栈信息
        StringBuilder errorMsg = new StringBuilder();
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
            errorMsg.append("\tat ").append(s).append("\r\n");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //日志具体参数
        StringBuffer sb = new StringBuffer();
        sb.append("-------------------" + sdf.format(new Date()) + "-------------------\r\n");
        sb.append("详细错误堆栈信息：" + ex + "\r\n");
        sb.append(errorMsg.toString() + "\r\n");
        sb.append("--------------------------------------------------------\r\n");
        FileUtil.write(fullPathName, sb.toString(), maxLength);

    }

    public static void writeLog(HttpServletRequest request, Exception ex, String fullPathName, int maxLength) {
        StringBuilder requestInfo = new StringBuilder();
        if(request!=null){
            requestInfo.append("Method=").append(request.getMethod()).append("\r\n");
            requestInfo.append("RequestURL=").append(request.getRequestURL()).append("\r\n");
            requestInfo.append("Protocol=").append(request.getProtocol()).append("\r\n");
            requestInfo.append("CharacterEncoding=").append(request.getCharacterEncoding()).append("\r\n");
            requestInfo.append("QueryString=").append(request.getQueryString()).append("\r\n");
        }


        //详细错误堆栈信息
        StringBuilder errorMsg = new StringBuilder();
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
            errorMsg.append("\tat ").append(s).append("\r\n");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //日志具体参数
        StringBuffer sb = new StringBuffer();
        sb.append("-------------------" + sdf.format(new Date()) + "-------------------\r\n");
        sb.append(requestInfo.toString()).append("\r\n");
        sb.append("详细错误堆栈信息：" + ex + "\r\n");
        sb.append(errorMsg.toString() + "\r\n");
        sb.append("--------------------------------------------------------\r\n");
        FileUtil.write(fullPathName, sb.toString(), maxLength);

    }
}
