package com.comaiot.net.library.bean;

import java.io.Serializable;

public class DevRegisterFaceInfo implements Serializable {
    private String cmd;
    private int progress;
    private int status;     //1代表正在录入 2代表录入成功(YD SDK应该进入配置名称界面) 3代表设备端退出录入
    private String devUid;
    private long createTime = System.currentTimeMillis();

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "DevRegisterFaceInfo{" +
                "cmd='" + cmd + '\'' +
                ", progress=" + progress +
                ", status=" + status +
                ", devUid='" + devUid + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
