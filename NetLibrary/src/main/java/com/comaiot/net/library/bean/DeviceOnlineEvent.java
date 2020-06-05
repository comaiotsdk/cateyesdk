package com.comaiot.net.library.bean;

import java.io.Serializable;

public class DeviceOnlineEvent implements Serializable {
    private String cmd;
    private String online;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "OnlineEntity{" +
                "cmd='" + cmd + '\'' +
                ", online='" + online + '\'' +
                '}';
    }
}
