package com.junmeng.exception;

import com.junmeng.enums.ResultCode;

/**
 * 实际业务异常
 * spring 对RuntimeException才有事务回滚
 * Created by HWJ on 2017/3/19.
 */
public class BussinessException extends RuntimeException {
    public int errorCode=-1;

    public BussinessException(ResultCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode.getCode();
    }
    public BussinessException(String message) {
        super(message);
    }
}
