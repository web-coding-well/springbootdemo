package com.junmeng.exception;

import com.junmeng.enums.ResultCode;

/**
 * spring 对RuntimeException才有事务回滚
 * Created by HWJ on 2017/3/19.
 */
public class CommonException extends RuntimeException {
    public int errorCode=-1;

    public CommonException(ResultCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode.getCode();
    }
    public CommonException( String message) {
        super(message);
    }
}
