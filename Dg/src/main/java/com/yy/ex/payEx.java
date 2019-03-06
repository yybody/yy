package com.yy.ex;

/**
 * @author 袁毅
 * @date 2018/12/25 0025-下午 2:06
 */
public class payEx extends RuntimeException {

    public payEx() {
    }

    public payEx(String message) {
        super(message);
        System.out.println(message);
    }

    public payEx(String message, Throwable cause) {
        super(message, cause);
    }

    public payEx(Throwable cause) {
        super(cause);
    }

    public payEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
