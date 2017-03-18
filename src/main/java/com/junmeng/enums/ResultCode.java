package com.junmeng.enums;

/**
 * Created by HWJ on 2017/3/19.
 */
public enum ResultCode {
    UNKNOW(-1,"未知错误"),
    SUCCESS(1,"成功"),
    FAILED(-99,"失败"),
    CANNOT_FIND(2,"找不到"),
    UNDER_AGE(3,"未成年"),
    ;
    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
