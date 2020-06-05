package com.comaiot.net.library.bean;

import java.io.Serializable;

public class DeviceRestartEvent implements Serializable {
    private String cmd;
    private int status;
    private long createTime;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DeviceRestartEvent{" +
                "cmd='" + cmd + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
