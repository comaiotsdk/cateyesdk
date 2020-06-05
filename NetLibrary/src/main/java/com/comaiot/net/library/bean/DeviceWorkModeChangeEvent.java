package com.comaiot.net.library.bean;

import java.io.Serializable;

public class DeviceWorkModeChangeEvent implements Serializable {
    private String cmd;
    private int workMode;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getWorkMode() {
        return workMode;
    }

    public void setWorkMode(int workMode) {
        this.workMode = workMode;
    }

    @Override
    public String toString() {
        return "DeviceWorkModeChangeEvent{" +
                "cmd='" + cmd + '\'' +
                ", workMode=" + workMode +
                '}';
    }
}
