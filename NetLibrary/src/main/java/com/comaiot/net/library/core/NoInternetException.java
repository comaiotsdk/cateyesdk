package com.comaiot.net.library.core;

/**
 * 无网络异常
 */
public class NoInternetException extends Exception {
    public NoInternetException() {
        super("The Application is not have Internet");
    }
}
