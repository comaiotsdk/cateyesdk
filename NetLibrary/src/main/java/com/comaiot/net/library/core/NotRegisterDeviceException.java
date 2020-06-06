package com.comaiot.net.library.core;

/**
 * SDK未成功注册异常，请稍等几秒
 */
public class NotRegisterDeviceException extends Exception {
    public NotRegisterDeviceException() {
        super("Please wait register complete.");
    }
}
