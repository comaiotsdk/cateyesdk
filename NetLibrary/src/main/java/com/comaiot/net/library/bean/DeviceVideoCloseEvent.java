package com.comaiot.net.library.bean;


import java.io.Serializable;

public class DeviceVideoCloseEvent implements Serializable {
    private String cmd;
    private String devUid;
    private long createTime;
    private String mode;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getDevUid() {
        return devUid;
    }

    public void setDevUid(String devUid) {
        this.devUid = devUid;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "DeviceVideoCloseEvent{" +
                "cmd='" + cmd + '\'' +
                ", devUid='" + devUid + '\'' +
                ", createTime=" + createTime +
                ", mode='" + mode + '\'' +
                '}';
    }
}
