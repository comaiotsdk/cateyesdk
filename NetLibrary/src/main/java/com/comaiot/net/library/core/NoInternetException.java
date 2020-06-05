package com.comaiot.net.library.core;

public class NoInternetException extends Exception {
    public NoInternetException() {
        super("The Application is not have Internet");
    }
}
