package com.comaiot.net.library.bean;


import java.io.Serializable;

public class DeviceRemoveEvent implements Serializable {
    private String cmd;
    private String devUid;
    private long createTime;
    private String appUid;

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

    public String getAppUid() {
        return appUid;
    }

    public void setAppUid(String appUid) {
        this.appUid = appUid;
    }

    @Override
    public String toString() {
        return "DeviceRemoveEvent{" +
                "cmd='" + cmd + '\'' +
                ", devUid='" + devUid + '\'' +
                ", createTime=" + createTime +
                ", appUid='" + appUid + '\'' +
                '}';
    }
}
