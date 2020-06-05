package com.comaiot.net.library.bean;


import java.io.Serializable;

public class DeviceAlarmEvent implements Serializable {
    private String cmd;
    private String devUid;
    private long createTime;
    private String type;
    private String mode;
    private String url;
    private String from;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "DeviceAlarmEvent{" +
                "cmd='" + cmd + '\'' +
                ", devUid='" + devUid + '\'' +
                ", createTime=" + createTime +
                ", type='" + type + '\'' +
                ", mode='" + mode + '\'' +
                ", url='" + url + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
