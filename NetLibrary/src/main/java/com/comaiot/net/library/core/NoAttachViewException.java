package com.comaiot.net.library.core;

public class NoAttachViewException extends Exception {
    public NoAttachViewException() {
        super("The Activity or Fragment must be attach view \r\n" + "Please use CatEyeController.attachView() ");
    }
}
