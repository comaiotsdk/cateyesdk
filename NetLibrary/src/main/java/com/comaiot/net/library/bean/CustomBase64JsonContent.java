package com.comaiot.net.library.bean;

import java.io.Serializable;

public class CustomBase64JsonContent implements Serializable {
    private String cmd;
    private String base64_custom_json;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getBase64_custom_json() {
        return base64_custom_json;
    }

    public void setBase64_custom_json(String base64_custom_json) {
        this.base64_custom_json = base64_custom_json;
    }

    @Override
    public String toString() {
        return "CustomBase64JsonContent{" +
                "cmd='" + cmd + '\'' +
                ", base64_custom_json='" + base64_custom_json + '\'' +
                '}';
    }
}
