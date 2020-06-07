package com.comaiot.net.library.bean;

import java.io.Serializable;

public class AppControlDevice extends CmdInfo implements Serializable {
    private int control_type;
    private int status;
    private String url;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getControl_type() {
        return control_type;
    }

    public void setControl_type(int control_type) {
        this.control_type = control_type;
    }

    @Override
    public String toString() {
        return "AppControlDevice{" +
                "control_type=" + control_type +
                ", status=" + status +
                ", url='" + url + '\'' +
                '}';
    }
}
