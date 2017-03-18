package com.junmeng.utils;

import com.junmeng.bean.Result;

/**
 * Created by HWJ on 2017/3/18.
 */
public class ResultUtil {
    public static Result success(Object data){
        Result result=new Result();
        result.setCode(1);
        result.setMessage("success");
        result.setData(data);
        return result;
    }
    public static Result success(){
        return success(null);
    }

    public static Result error(int errorCode,String message){
        Result result=new Result();
        result.setCode(errorCode);
        result.setMessage(message);
        return result;
    }
}
